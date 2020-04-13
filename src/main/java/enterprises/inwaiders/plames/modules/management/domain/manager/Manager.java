package enterprises.inwaiders.plames.modules.management.domain.manager;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public interface Manager {

	public void setLogin(String login);
	public String getLogin();

	public void setPassHash(String hash);
	public String getPassHash();
	
	public void setRoles(List<String> roles);
	public List<String> getRoles();
	
	public UserDetails getUserDetails();
	
	public Long getId();
}
