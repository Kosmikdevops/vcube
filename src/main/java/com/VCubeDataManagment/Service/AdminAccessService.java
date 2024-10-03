package com.VCubeDataManagment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VCubeDataManagment.Entity.AdminAccess;
import com.VCubeDataManagment.Repository.AdminAccessRepository;

@Service
public class AdminAccessService implements AdminAccessServ{

	@Autowired
	private AdminAccessRepository repo;
	
	public AdminAccess checkAdminValidornot(AdminAccess access) {
		AdminAccess admin = repo.findByUsernameAndPassword(access.getUsername(), access.getPassword());
		
		return admin;
	}
}
