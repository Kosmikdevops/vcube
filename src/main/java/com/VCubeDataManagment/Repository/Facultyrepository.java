package com.VCubeDataManagment.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.VCubeDataManagment.Entity.Admin;
import com.VCubeDataManagment.Entity.Faculty;

@Repository
public interface Facultyrepository extends JpaRepository<Faculty,Long>{

	@Query("SELECT f FROM Faculty f WHERE f.course.coursename = :courseName")
    List<Faculty> findFacultyByCourseName(@Param("courseName") String courseName);
}
