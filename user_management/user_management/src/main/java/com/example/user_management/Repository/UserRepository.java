package com.example.user_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_management.Entity.User;

public interface UserRepository extends JpaRepository <User,Long>{

}
