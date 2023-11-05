package com.agent47.StudentManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DuplicateFirstNameException extends RuntimeException{
    private String message;
}
