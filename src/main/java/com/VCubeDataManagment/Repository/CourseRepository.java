package com.VCubeDataManagment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.VCubeDataManagment.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	@Query("SELECT u FROM Course u WHERE u.coursename=?1 ")
    Optional<Course> findCourseByCName(String cname);
}
