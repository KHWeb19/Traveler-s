package com.example.demo.entity.member;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.wish.Wish;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String mobile;

    @CreationTimestamp
    private Date reg_date;

    private String profile_path;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    @JoinTable(
            name="USER_ROLE",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    @Builder.Default
    private List<Role> roles = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Hotel> hotels= new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wish> wish= new ArrayList<>();


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void addRoleToUser(Role role){
        this.getRoles().add(role);
        role.getUsers().add(this);
    }

}