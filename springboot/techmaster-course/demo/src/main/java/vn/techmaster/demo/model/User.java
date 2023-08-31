package vn.techmaster.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@FieldDefaults(level = AccessLevel.PRIVATE) // set private
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
