package kodlama.io.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getByEmail/{email}")
	public DataResult<List<User>>getByEmail(@RequestParam String email){
		return this.userService.getByEmail(email);
	}
	@DeleteMapping("/deleteById/{id}")
	
	public Result deleteById(@RequestParam int id) {
		return this.userService.deleteById(id);
	}
	@GetMapping("/getAll")
	public DataResult<List<User>>getAll(){
		return this.userService.getAll();
	}
}
