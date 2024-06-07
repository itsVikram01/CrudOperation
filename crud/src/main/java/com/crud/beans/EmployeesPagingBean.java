package com.crud.beans;

import com.crud.model.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeesPagingBean {

        private Employee employeeBean;

        @Min(value = 0, message = "{validation.pageNo.min}")
        private Integer pageNo;

        @Min(value = 1, message = "{validation.pageSize.min}")
        private Integer pageSize;

        private String[] sortingFieldWithOrder;
}
