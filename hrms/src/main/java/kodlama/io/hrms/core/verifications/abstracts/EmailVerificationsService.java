package kodlama.io.hrms.core.verifications.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;

public interface EmailVerificationsService {
	public Result verifyEmail(String email);
}
