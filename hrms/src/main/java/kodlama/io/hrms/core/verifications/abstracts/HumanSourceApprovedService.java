package kodlama.io.hrms.core.verifications.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

public interface HumanSourceApprovedService {
	public Result isApprovedFromHumanSource(Employer employer);
}
