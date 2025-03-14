package com.GIMP_plugin_repository.User.Repository;

import com.GIMP_plugin_repository.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
