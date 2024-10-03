package com.VCubeDataManagment.Service;

import org.springframework.http.ResponseEntity;

import com.VCubeDataManagment.Entity.Admin;
import com.VCubeDataManagment.Entity.LoginModel;

public interface Adminservice1 {

	ResponseEntity<Admin> saveadmin(Admin admin);

	ResponseEntity<Admin> findbyUserNameandPassword(String email,String password);
}
