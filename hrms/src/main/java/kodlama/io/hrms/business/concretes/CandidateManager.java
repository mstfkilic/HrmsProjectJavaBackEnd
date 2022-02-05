package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.adapters.abstracts.MernisCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.verifications.abstracts.EmailVerificationsService;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.User;
import kodlama.io.hrms.entities.concretes.Dtos.CandidateDtoForRegister;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private EmailVerificationsService emailVerificationsService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisCheckService mernisCheckService,EmailVerificationsService emailVerificationsService) {
		this.candidateDao = candidateDao;
		this.emailVerificationsService = emailVerificationsService;
		this.mernisCheckService = mernisCheckService;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"All candidates are listed.");
	}
	
	public Result isMailExist(String email) {
		if(this.candidateDao.getByEmail(email)!=null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	public Result isIdentityNumberExist(String identityNumber) {
		if(this.candidateDao.getByIdentityNumber(identityNumber)!= null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	//@Override
	//public Result add(Candidate candidate) throws Exception {
		// TODO Auto-generated method stub
		
		//if(this.isMailExist(candidate.getEmail()).isSuccess() || this.isIdentityNumberExist(candidate.getIdentityNumber()).isSuccess()) {
			//return new ErrorResult("Failed!");
		//jnu9gv hdftuxes5}
		
		//Result checkedPerson;
		
		//checkedPerson = mernisCheckService.checkIfRealPerson(candidate);
		
		//if(!this.mernisCheckService.checkIfRealPerson(candidate).isSuccess()) {
			//return new ErrorResult("Person not a valid");
		//}
		
		//if(!this.emailVerificationsService.verifyEmail(candidate.getEmail()).isSuccess()) {
			//return new ErrorResult("Check your email!");
		//}
		
		//this.candidateDao.saveAndFlush(candidate);
		//return new SuccessResult("Candidate is saved to system.");
	//}

	@Override
	public Result add(CandidateDtoForRegister candidateDtoForRegister) throws Exception {
		// TODO Auto-generated method stub
		Candidate candidate = candidateDtoConvertCandidate(candidateDtoForRegister);
		Result checkedPerson;
		
		checkedPerson = mernisCheckService.checkIfRealPerson(candidate);
		if(!this.mernisCheckService.checkIfRealPerson(candidate).isSuccess()) {
			return new ErrorResult("Person not a valid");
		}
		if(!this.emailVerificationsService.verifyEmail(candidate.getEmail()).isSuccess()) {
			return new ErrorResult("Check your email");
		}
		
		if(this.isIdentityNumberExist(candidate.getIdentityNumber()).isSuccess()) {
			return new ErrorResult("Identity Number already exist");
		}
		if(this.isMailExist(candidate.getEmail()).isSuccess()) {
			return new ErrorResult("Mail address already exist");
			
		}
		
		this.candidateDao.save(candidate);
		
		return new SuccessResult("Candidate added to system");
	}
	
	private Candidate candidateDtoConvertCandidate(CandidateDtoForRegister candidateDtoForRegister) {
		Candidate candidate = new Candidate();
		candidate.setFirstName(candidateDtoForRegister.getFirstName());
		candidate.setLastName(candidateDtoForRegister.getLastName());
		candidate.setIdentityNumber(candidateDtoForRegister.getIdentityNumber());
		candidate.setEmail(candidateDtoForRegister.getEmail());
		candidate.setBirthYear(candidateDtoForRegister.getBirthYear());
		candidate.setPassword(candidateDtoForRegister.getPassword());
		
		return candidate;
		
	}

	@Override
	public Result deleteById(int user_id) {
		this.candidateDao.deleteById(user_id);
		return new SuccessResult("Candidate are removed from system.");
	}

	@Override
	public DataResult<Candidate> update(int candidateId, Candidate candidateInfo) {
		Candidate candidate = this.candidateDao.getById(candidateId);
		candidate.setFirstName(candidateInfo.getFirstName());
		candidate.setLastName(candidateInfo.getLastName());
		candidate.setIdentityNumber(candidateInfo.getIdentityNumber());
		candidate.setBirthYear(candidateInfo.getBirthYear());
		candidate.setEmail(candidateInfo.getEmail());
		candidate.setPassword(candidateInfo.getPassword());
		
		this.candidateDao.save(candidate);
		return new SuccessDataResult<Candidate>(candidate,"Candidate is updated");
	}

	

}
