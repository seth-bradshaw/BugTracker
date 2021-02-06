package com.portfolio.bugtracker.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Login credentials.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginCredentials
{
    private String username;
    private String password;
}