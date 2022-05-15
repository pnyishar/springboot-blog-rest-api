package com.pantech.blog.dto;

import lombok.Data;

/**
 * @author Paul Nyishar
 * @Date 15/05/2022
 */
@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
