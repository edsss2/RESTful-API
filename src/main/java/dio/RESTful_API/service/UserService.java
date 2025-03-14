package dio.RESTful_API.service;

import dio.RESTful_API.domain.model.User;

public interface UserService {

	User findById(long id);
	User create(User userToCreate);
}
