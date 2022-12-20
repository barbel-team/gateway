package com.example.TeamProject01.Domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @NotBlank(message = "mail is blank")
    @Email
    private String email01;

    @NotBlank(message = "id is blank")
    private String id01;

    @NotBlank
    private String pwd01;

    @NotBlank
    private String name01;

    @NotBlank
    private String n_name;

    @NotBlank
    private String addr01;

    @NotBlank
    private String addr02;

    @NotBlank
    private String addr03;


    private Date r_date01;
    private long p_time;

    private boolean enabled;

    @ManyToMany
    @JoinTable(
            name = "member_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();
}
