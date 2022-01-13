package kodlama.io.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.verifications.abstracts.EmailVerificationsService;

@Service
public class EmailVerificationsManager implements EmailVerificationsService {

	@Override
	public Result verifyEmail(String email) {
		return new SuccessResult();
	}

}
