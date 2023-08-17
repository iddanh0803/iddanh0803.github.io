package vn.techmaster.demo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder // design pattern builder

public class Post {
    private Integer id;
    @NotNull(message = "Tiêu đề không được để trống")
    @Size(min = 5, max = 50, message = "Tiêu đề phải từ 2 đến 50 ký tự")
    private String title;
    @NotNull(message = "Tên tác giả không được để trống")
    private String author;

}
