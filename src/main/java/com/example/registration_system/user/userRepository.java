package com.example.registration_system.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Long>{
    @Query("select u from User u where u.email=?1 ")
    User findByEmail(String email);


}