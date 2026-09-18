package com.scaler.splitwisesept26.repositories;

import com.scaler.splitwisesept26.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
