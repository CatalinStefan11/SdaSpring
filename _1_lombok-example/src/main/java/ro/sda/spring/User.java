package ro.sda.spring;


import lombok.*;

import java.util.Objects;


// @Data -> shortcut for @ToString, @EqualsAndHashCode, @Getter / @Setter
@ToString
@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private int age;
}
