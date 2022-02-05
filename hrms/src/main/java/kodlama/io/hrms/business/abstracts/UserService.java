package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>>getByEmail(String email);
	Result deleteById(int id);
	DataResult<List<User>>getAll();
}
