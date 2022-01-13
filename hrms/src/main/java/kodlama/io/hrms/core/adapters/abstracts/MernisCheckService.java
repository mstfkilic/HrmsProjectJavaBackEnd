package kodlama.io.hrms.core.adapters.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;

public interface MernisCheckService {
	
	Result checkIfRealPerson(Candidate candidate) throws Exception;
	
}
