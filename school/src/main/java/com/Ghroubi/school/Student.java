package com.Ghroubi.school;

import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String firstname;
    private String lastname;
    private String email;

}
