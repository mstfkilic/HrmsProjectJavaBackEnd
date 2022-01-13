package kodlama.io.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.verifications.abstracts.HumanSourceApprovedService;
import kodlama.io.hrms.entities.concretes.Employer;
@Service
public class HumanSourceApprovedManager implements HumanSourceApprovedService {

	@Override
	public Result isApprovedFromHumanSource(Employer employer) {
		// TODO Auto-generated method stub
		return new SuccessResult();
	}

}
