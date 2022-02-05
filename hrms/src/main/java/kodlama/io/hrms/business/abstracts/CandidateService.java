package kodlama.io.hrms.business.abstracts;


import java.util.List;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Dtos.CandidateDtoForRegister;


public interface CandidateService {

	DataResult<List<Candidate>>getAll();
	Result add(CandidateDtoForRegister candidateDtoForRegister) throws Exception;
	Result deleteById (int user_id);
	DataResult<Candidate>update(int candidateId,Candidate candidateInfo);
	
}
