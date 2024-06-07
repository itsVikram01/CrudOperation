package com.crud.beans;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeBean implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
