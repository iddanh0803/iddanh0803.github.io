package com.example.Day8.dto;

import com.example.Day8.entity.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDto {
    private Integer id;
    private String name;
    public RoleDto(Role role){
        this.id = role.getId();
        this.name = role.getName();
    }
}
