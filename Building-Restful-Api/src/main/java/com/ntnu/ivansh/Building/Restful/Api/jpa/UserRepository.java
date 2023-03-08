package com.ntnu.ivansh.Building.Restful.Api.jpa;

import com.ntnu.ivansh.Building.Restful.Api.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
