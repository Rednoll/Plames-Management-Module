package com.inwaiders.plames.modules.management;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inwaiders.plames.domain.module.impl.ModuleBase;
import com.inwaiders.plames.modules.management.domain.manager.impl.ManagerImpl;

public class ManagementModule extends ModuleBase {

	private static ManagementModule instance = new ManagementModule();
	
	@Override
	public void init() {
		
		List<ManagerImpl> managers = ManagerImpl.getAll();
	
		if(managers.isEmpty()) {
			
			ManagerImpl manager = ManagerImpl.create();
			
				manager.setLogin("admin");
				manager.setPassHash(new BCryptPasswordEncoder().encode("admin"));
				
			manager.save();
		}
	}

	@Override
	public String getName() {
		
		return "Management";
	}

	@Override
	public String getVersion() {
		
		return "1V";
	}

	@Override
	public String getDescription() {
		
		return "Модуль пользовательского управления системой Plames.";
	}

	@Override
	public String getType() {
		
		return "support";
	}

	@Override
	public String getLicenseKey() {
		
		return null;
	}

	@Override
	public long getSystemVersion() {
		
		return 0;
	}

	@Override
	public long getId() {
	
		return 5467;
	}
	
	public static ManagementModule getInstance() {
		
		return instance;
	}
}
