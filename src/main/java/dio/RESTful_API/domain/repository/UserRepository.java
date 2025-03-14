package dio.RESTful_API.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.RESTful_API.domain.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
