package enterprises.inwaiders.plames.modules.management.dao.manager;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enterprises.inwaiders.plames.modules.management.domain.manager.impl.ManagerImpl;

@Service
public class ManagerRepositoryInjector {

	@Autowired
	private ManagerRepository repository;

	@PostConstruct
	private void inject() {
		
		ManagerImpl.setRepository(repository);
	}
}
