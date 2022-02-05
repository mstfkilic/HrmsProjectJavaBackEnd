package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CoverLetter;
import kodlama.io.hrms.entities.concretes.Dtos.CoverLetterDto;

public interface CoverLetterService {

	DataResult<CoverLetter> getByCandidateId(int candidateId);
	Result deleteById(int id);
	Result add(CoverLetterDto coverLetterDto);
	Result update(int candidateId,String text);
}
