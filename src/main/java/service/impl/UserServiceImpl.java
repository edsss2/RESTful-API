package service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import domain.model.User;
import domain.repository.UserRepository;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImpl (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if (userToCreate != null && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("This User ID alredy existys.");
		}
		return userRepository.save(userToCreate);
	}

}
