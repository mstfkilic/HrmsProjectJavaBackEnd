package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getByEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(this.userDao.getByEmail(email),"All user's email are listed");
		
	}

	@Override
	public Result deleteById(int id) {
		// TODO Auto-generated method stub
		this.userDao.deleteById(id);
		return new SuccessResult("User is removed from database");
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"All users are listed");
	}

}
