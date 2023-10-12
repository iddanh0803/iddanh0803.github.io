package com.example.Day8.dto;

import com.example.Day8.entity.Role;
import com.example.Day8.entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private List<RoleDto> roles;
    private String avatar;
    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.roles = user.getRoles().stream().map(role -> new RoleDto(role)).toList();
        this.avatar = user.getAvatar();
    }
}
