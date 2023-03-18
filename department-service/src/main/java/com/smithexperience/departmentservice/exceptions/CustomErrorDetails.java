package com.smithexperience.departmentservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Set up custom Error attributes for when accessing the API and an error occurs
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;
}
