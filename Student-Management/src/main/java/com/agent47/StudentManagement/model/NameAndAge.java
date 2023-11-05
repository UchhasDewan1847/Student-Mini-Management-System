package com.agent47.StudentManagement.model;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class NameAndAge {
    private String firstName;

    private Short age;
}
