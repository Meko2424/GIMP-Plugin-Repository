package com.GIMP_plugin_repository.BackEnd.User.Repository;

import com.GIMP_plugin_repository.BackEnd.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User , Integer> {
    User findByEmailId(String role);
}
