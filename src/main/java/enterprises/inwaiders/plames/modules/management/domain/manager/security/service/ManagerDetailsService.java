package enterprises.inwaiders.plames.modules.management.domain.manager.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import enterprises.inwaiders.plames.modules.management.domain.manager.Manager;
import enterprises.inwaiders.plames.modules.management.domain.manager.impl.ManagerImpl;

@Service
@Transactional
public class ManagerDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Manager manager = ManagerImpl.getByLogin(username);
		
		if(manager == null) {
			
			throw new UsernameNotFoundException("User with login: "+username+" not found!");
		}
		
		System.out.println("OK! Manager");
		
		return manager.getUserDetails();
	}
}
