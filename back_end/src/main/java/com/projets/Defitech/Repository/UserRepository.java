package com.projets.Defitech.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projets.Defitech.Models.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
