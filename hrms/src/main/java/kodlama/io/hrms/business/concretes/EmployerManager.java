package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.verifications.abstracts.EmailVerificationsService;
import kodlama.io.hrms.core.verifications.abstracts.HumanSourceApprovedService;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private EmailVerificationsService emailVerificationsService;
	private HumanSourceApprovedService humanSourceApprovedService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailVerificationsService emailVerificationsService,HumanSourceApprovedService humanSourceApprovedService) {
		this.employerDao = employerDao;
		this.emailVerificationsService = emailVerificationsService;
		this.humanSourceApprovedService = humanSourceApprovedService;
	}
	
	
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"All Employers are listed.");
	}
	
	
	public Result isEMailExist(String email) {
		if(this.employerDao.findByEmail(email)!= null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	
	@Override
	public Result add(Employer employer) throws Exception {
		// TODO Auto-generated method stub
		if(this.isEMailExist(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Email has already exist");
		}
		
		if(!this.humanSourceApprovedService.isApprovedFromHumanSource(employer).isSuccess()){
			return new ErrorResult("Employer is not approved from H.R. personel.");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer added");
	}
}
