package com.scaler.splitwisesept26.repositories;

import com.scaler.splitwisesept26.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
