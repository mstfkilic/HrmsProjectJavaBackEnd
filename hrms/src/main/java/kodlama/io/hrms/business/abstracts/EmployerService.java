package kodlama.io.hrms.business.abstracts;

import java.util.List;



import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.Dtos.EmployerDtoForRegister;


public interface EmployerService {
	DataResult<List<Employer>>getAll();
	
	Result add(EmployerDtoForRegister employerDtoForRegister) throws Exception;
	Result delete(int employerId);
	DataResult<Employer>update(int employerId,Employer employerInfo);
}
