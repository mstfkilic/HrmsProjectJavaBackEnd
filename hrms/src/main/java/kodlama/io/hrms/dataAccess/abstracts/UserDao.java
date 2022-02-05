package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {

	List<User>getByEmail(String email);
	User deleteById(int id);
	
}
