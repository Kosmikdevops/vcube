package com.VCubeDataManagment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.VCubeDataManagment.Entity.Admin;
@Repository
public interface Adminrepository extends JpaRepository<Admin, Long> {

	@Query("SELECT u FROM Admin u WHERE u.email = ?1 AND u.password = ?2")
    Optional<Admin> findAdminbynameAndPassword(String email, String password);
}
