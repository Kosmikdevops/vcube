package com.VCubeDataManagment.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.VCubeDataManagment.Dto.StudentDto;
import com.VCubeDataManagment.Entity.Batch;
import com.VCubeDataManagment.Entity.Course;
import com.VCubeDataManagment.Entity.Student;
import com.VCubeDataManagment.Repository.BatchRepository;
//import com.VCubeDataManagment.Entity.Student;
import com.VCubeDataManagment.Repository.StudentRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class StudentService implements Studentserv{

	@Autowired
	private StudentRepository repo;
	@Autowired
	private BatchService batchservice;
	@Autowired
	private BatchRepository batchRepository;
	@Autowired
	private HttpSession session;
	@Autowired
	private CourseService courseservice;
	private static final String PREFIX = "VC-JFT";
	@Override
	public ResponseEntity<Batch> saveStudent(StudentDto studentdto,Batch batch) {
		
		ResponseEntity<Course> courseByName = courseservice.getCourseByName(studentdto.getCoursename());
		System.out.println(courseByName);
		Student s=new Student();
		s.setAddress(studentdto.getAddress());
		s.setCgpa(studentdto.getGPA());
		s.setCourse(courseByName.getBody());
		s.setBatchname(batch.getBatchname());
		s.setFirstname(studentdto.getFirstname());
		s.setLastname(studentdto.getLastname());
		s.setDob(studentdto.getDob());
		s.setBatchname(batch.getBatchname());
		s.setCgpa(studentdto.getGPA());
		s.setEmail(studentdto.getEmail());
		s.setAddress(studentdto.getAddress());
		s.setPhonenumber(studentdto.getPhonenumber());
		s.setEnrollmentdate(studentdto.getEnrollmentdate());
		s.setGender(studentdto.getGender());
		s.setPassedoutyear(studentdto.getPassedoutyear());
		s.setPassword(studentdto.getPassword());
		s.setStudentno(createStudent(PREFIX, batch));
		s.setQualification(studentdto.getQualification());
//		System.out.println(s+"(((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))");
		Set<Student> listudent = batch.getStudent();
		listudent.add(s);
		System.out.println(listudent+"{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
		batch.setStudent(listudent);
//		System.out.println(batch+" 0------------------------------------------------------------batch------------------------------------------------------------");
//		Student save = repo.save(s);
//		System.out.println(save+" after save student details((((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
		Batch b1 = batchRepository.save(batch);
		System.out.println(b1+" after save batch details ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		return new ResponseEntity<Batch>(b1,HttpStatus.OK);
		
		
	}
	@Override
	public ResponseEntity<Batch> getBatchByBatchId(long id) {
		ResponseEntity<Batch> batchById = batchservice.getBatchById(id);
		
		return new ResponseEntity<Batch>(batchById.getBody(),HttpStatus.OK);
	}
	private  String createStudent(String name, Batch batch) {
        // Fetch the batch
//        Batch batch = batchRepository.findById(batchId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid batch ID"));

        // Increment the student number for this batch
        batch.setLastStudentNumber(batch.getLastStudentNumber() + 1);
        batchRepository.save(batch);

        // Generate the student ID
        String studentId = PREFIX + String.format("%03d", batch.getLastStudentNumber());

       
        return studentId;
    }

}
