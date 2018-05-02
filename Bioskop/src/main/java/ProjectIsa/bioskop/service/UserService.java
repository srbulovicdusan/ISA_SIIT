package ProjectIsa.bioskop.service;

import java.util.Collection;

import ProjectIsa.bioskop.domain.Adresa;
import ProjectIsa.bioskop.domain.User;

public interface UserService {
	
	Collection<User> getUsers();
	
	User addUser(User user);
	
	Adresa addAddress(Adresa address);
	void deleteUser(User user);
	User getUser(String id);

	Boolean changePassword(User user, String newPassword);

	User changeProfile(User user, User changedUser);
	
}
