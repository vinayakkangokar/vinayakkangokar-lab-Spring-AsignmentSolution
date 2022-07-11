package com.gl.collegedebateevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gl.collegedebateevent.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
