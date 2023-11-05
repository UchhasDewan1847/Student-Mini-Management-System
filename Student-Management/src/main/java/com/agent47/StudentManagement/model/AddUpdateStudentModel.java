package com.agent47.StudentManagement.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUpdateStudentModel {
    //just for update
    private Long id;
    @NotNull(message = "First Name cannot be null or Empty")
    private String firstName;
    private String lastName;
    @NotNull(message = "qualification cannot be null or Empty")
    private String qualification;
    @NotNull(message = "age cannot be null or Empty")
    @Min(18)
    private Short age;
}
