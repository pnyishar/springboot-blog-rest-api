package com.pantech.blog.controller;

import com.pantech.blog.dto.JWTAuthResponse;
import com.pantech.blog.dto.LoginDto;
import com.pantech.blog.dto.SignUpDto;
import com.pantech.blog.entity.Role;
import com.pantech.blog.entity.User;
import com.pantech.blog.respository.RoleRepository;
import com.pantech.blog.respository.UserRepository;
import com.pantech.blog.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul Nyishar
 * @Date 15/05/2022
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token from tokenProvider
        String token = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpDto signUpDto){
      // Check if user exists in DB
      if(userRepository.existsByUsername(signUpDto.getUsername())){
          return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
      }
      // check if email exists in DB
      if(userRepository.existsByEmail(signUpDto.getEmail())){
          return new ResponseEntity<>("Email already taken!", HttpStatus.BAD_REQUEST);
      }

      User user = new User();
      user.setName(signUpDto.getName());
      user.setUsername(signUpDto.getUsername());
      user.setEmail(signUpDto.getEmail());
      user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

      Role roles = roleRepository.findByName("ROLE_ADMIN").get();

      userRepository.save(user);

      return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}
