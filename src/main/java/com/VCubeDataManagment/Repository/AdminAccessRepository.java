package com.VCubeDataManagment.Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.VCubeDataManagment.Entity.AdminAccess;

@Repository
public interface AdminAccessRepository extends JpaRepository<AdminAccess, Long>{

	@Query("SELECT a FROM AdminAccess a WHERE a.username = :username AND a.password = :password")
    AdminAccess findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
