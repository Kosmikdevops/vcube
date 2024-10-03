package com.VCubeDataManagment.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.VCubeDataManagment.Entity.Admin;
import com.VCubeDataManagment.Entity.LoginModel;
import com.VCubeDataManagment.Exceptionlayer.AdminDataisnotfound;
import com.VCubeDataManagment.Repository.Adminrepository;

@Service
public class Adminservice implements Adminservice1 {

	@Autowired
	private Adminrepository repo;
	@Override
	public ResponseEntity<Admin> saveadmin(Admin admin) {
		Admin  aftersave= repo.save(admin);
		return new ResponseEntity<Admin>(aftersave,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Admin> findbyUserNameandPassword(String email,String password){
		
		
		
	        System.out.println(email+" come from front end");
	        System.out.println(password+" come from front end");
			Optional<Admin> adminbynameAndPassword = repo.findAdminbynameAndPassword(email,password);
			if(adminbynameAndPassword.isEmpty()) {
				return new ResponseEntity<Admin>(adminbynameAndPassword.get(),HttpStatus.NOT_FOUND); 
			}
			return new ResponseEntity<Admin>(adminbynameAndPassword.get(),HttpStatus.FOUND);
		
	}

}
