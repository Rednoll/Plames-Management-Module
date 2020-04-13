package enterprises.inwaiders.plames.modules.management.domain.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import enterprises.inwaiders.plames.modules.management.dao.manager.ManagerRepository;
import enterprises.inwaiders.plames.modules.management.domain.manager.Manager;

@Entity(name = "Manager")
@Table(name = "Management_Manager")
public class ManagerImpl implements Manager {
	
	private static transient ManagerRepository repository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id = null;
	
	@Column(name = "login")
	private String login = null;
	
	@Column(name = "pass_hash")
	private String passHash = null;
	
	@Column(name = "roles")
	@ElementCollection
	private List<String> roles = new ArrayList<>();
	
	@Column(name = "deleted")
	private volatile boolean deleted = false;
	
	@Override
	public UserDetails getUserDetails() {
		
		List<GrantedAuthority> grantedAuthority = getGrantedAuthority();
		
		UserDetails user = new org.springframework.security.core.userdetails.User(login, passHash, grantedAuthority);
	
		return user;
	}
	
	private List<GrantedAuthority> getGrantedAuthority() {
		
		List<GrantedAuthority> result = new ArrayList<>();
		
		for(String role : roles) {
			
			result.add(new SimpleGrantedAuthority(role));
		}
		
		return result;
	}
	
	@Override
	public void setLogin(String login) {
		
		this.login = login;
	}

	@Override
	public String getLogin() {
		
		return this.login;
	}

	@Override
	public void setPassHash(String hash) {
		
		this.passHash = hash;
	} 

	@Override
	public String getPassHash() {
		
		return this.passHash;
	}

	@Override
	public void setRoles(List<String> roles) {
		
		this.roles = roles;
	}

	@Override
	public List<String> getRoles() {
		
		return this.roles;
	}
	
	@Override
	public Long getId() {
		
		return this.id;
	}
	
	public void save() {
		
		if(!deleted) {
			
			repository.save(this);
		}
	}
	
	public void delete() {
		
		deleted = true;
		repository.save(this);
	}
	
	public static ManagerImpl create() {

		ManagerImpl manager = new ManagerImpl();
		
		manager = repository.save(manager);
		
		return manager;
	}
	
	public static ManagerImpl getByLogin(String login) {
		
		return repository.getByLogin(login);
	}
	
	public static ManagerImpl getById(long id) {
		
		return repository.getOne(id);
	}
	
	public static List<ManagerImpl> getAll() {
		
		return repository.findAll();
	}
	
	public static void setRepository(ManagerRepository rep) {
		
		repository = rep;
	}
}
