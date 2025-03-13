package service;

import domain.model.User;

public interface UserService {

	User findById(long id);
	User create(User userToCreate);
}
