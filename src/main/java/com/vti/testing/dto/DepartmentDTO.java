package com.vti.testing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vti.testing.entity.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
public class DepartmentDTO {
    private int id;
    private String name;
    @JsonProperty("totalMember")
    private int totalMember;
    private Type type;
    // sửa clg j đó
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdDate;
    private List<AccountDTO> accounts;
    @Data
    @NoArgsConstructor
    static class AccountDTO {
        private int id;
        private String username;
    }

}
