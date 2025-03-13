package controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import domain.model.User;
import io.swagger.v3.oas.annotations.Operation;
import service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	@Operation(summary = "Busca um usuário por ID", description = "Retorna um usuário baseado no ID fornecido")
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		var user = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@Operation(summary = "Cria um novo usuário", description = "Cria e retorna um novo usuário")
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		var userCreated = userService.create(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userCreated.getId())
				.toUri();
		
		
		return ResponseEntity.created(location).body(userCreated);
	}
	
	
	
	
}
