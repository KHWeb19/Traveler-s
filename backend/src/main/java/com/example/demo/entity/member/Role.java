package com.example.demo.entity.member;

import com.example.demo.entity.member.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy="roles")
    private Collection<User> users = new ArrayList<>();

    public Role(String name) {
        this.name = name;
    }
}
