package com.example.Day8.request;

import com.example.Day8.entity.Role;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertUserRequest {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String avatar;
    private List<Role> roles;
}
