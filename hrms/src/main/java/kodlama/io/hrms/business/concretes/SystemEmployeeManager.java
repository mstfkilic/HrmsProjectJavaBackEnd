package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SystemEmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlama.io.hrms.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {

	private SystemEmployeeDao systemEmployeeDao;
	
	
	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
		super();
		this.systemEmployeeDao = systemEmployeeDao;
	}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll(),"All System Employees personel are listed.");
	}

	@Override
	public Result add(SystemEmployee systemEmployee) {
		// TODO Auto-generated method stub
		this.systemEmployeeDao.save(systemEmployee);
		
		return new SuccessResult("System employee personel is added to database");
	}
	
}
