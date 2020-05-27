package enterprises.inwaiders.plames.modules.management;

import java.io.File;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import enterprises.inwaiders.plames.domain.module.impl.ModuleBase;
import enterprises.inwaiders.plames.modules.management.domain.manager.impl.ManagerImpl;

public class ManagementModule extends ModuleBase {

	private static ManagementModule instance = new ManagementModule();
	
	@Override
	public void init() {
		
		List<ManagerImpl> managers = ManagerImpl.getAll();
	
		if(managers.isEmpty()) {
			
			initAdminUser();
		}
	}
	
	private void initAdminUser() {
		
		
		ManagerImpl manager = ManagerImpl.create();
		
		File mainProps = new File("main.properties");
		
		if(mainProps.exists()) {
			
		}
		else {
			
			manager.setLogin("admin");
			manager.setPassHash(new BCryptPasswordEncoder().encode("admin"));
		}
		
		manager.save();
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
