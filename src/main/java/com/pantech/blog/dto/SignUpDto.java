package com.pantech.blog.dto;

import lombok.Data;

/**
 * @author Paul Nyishar
 * @Date 16/05/2022
 */
@Data
public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
