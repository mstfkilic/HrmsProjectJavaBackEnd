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
import kodlama.io.hrms.entities.concretes.Dtos.EmployerDtoForRegister;

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
		if(this.employerDao.getByEmail(email)!= null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	
	//@Override
	//public Result add(Employer employer) throws Exception {
		// TODO Auto-generated method stub
	//	if(this.isEMailExist(employer.getEmail()).isSuccess()) {
	//		return new ErrorResult("Email has already exist");
	//	}
		
	//	if(!this.humanSourceApprovedService.isApprovedFromHumanSource(employer).isSuccess()){
	//		return new ErrorResult("Employer is not approved from H.R. personel.");
	//	}
	//	this.employerDao.save(employer);
	//	return new SuccessResult("Employer added");
	//}




	@Override
	public Result add(EmployerDtoForRegister employerDtoForRegister) throws Exception {
		Employer employer = employerDtoConvertEmployer(employerDtoForRegister);
		if(this.isEMailExist(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Mail address already used");
		}
		if(!this.humanSourceApprovedService.isApprovedFromHumanSource(employer).isSuccess()){
			return new ErrorResult("The employer dont confirm by Human Resources Personnel");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Employer is added to system");
	}

	private Employer employerDtoConvertEmployer(EmployerDtoForRegister employerDtoForRegister) {
		
		Employer employer = new Employer();
		
		employer.setCompanyName(employerDtoForRegister.getCompanyName());
		employer.setEmail(employerDtoForRegister.getEmail());
		employer.setWebAddress(employerDtoForRegister.getWebAddress());
		employer.setPhoneNumber(employerDtoForRegister.getPhoneNumber());
		employer.setPassword(employerDtoForRegister.getPassword());
		
		return employer;
	}


	@Override
	public Result delete(int employerId) {
		this.employerDao.deleteById(employerId);
		return new SuccessResult("Employer is removed from system");
	}
	


	@Override
	public DataResult<Employer> update(int employerId, Employer employerInfo) {
		Employer employer = this.employerDao.getById(employerId);
		employer.setCompanyName(employerInfo.getCompanyName());
		employer.setWebAddress(employerInfo.getWebAddress());
		employer.setPhoneNumber(employerInfo.getPhoneNumber());
		employer.setEmail(employerInfo.getEmail());
		employer.setPassword(employerInfo.getPassword());
		
		this.employerDao.save(employer);
		return new SuccessDataResult<Employer>(employer,"Employer is updated.");
	}
}
