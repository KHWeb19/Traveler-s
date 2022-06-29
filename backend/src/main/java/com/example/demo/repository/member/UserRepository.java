package com.example.demo.repository.member;

import com.example.demo.entity.member.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByEmail(String email);

        @Query("select m.email from User m where m.email = :email")
        Optional<User> checkEmail(@Param("email") String email);


        Optional<User> findByMobile(String mobile);

        @Query("select u from User u join fetch u.hotels where u.email = :email")
        Optional<User> findByEmailWithHotels(String email);
}

