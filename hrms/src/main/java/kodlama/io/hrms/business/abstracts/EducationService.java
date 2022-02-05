package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.Dtos.EducationDto;

public interface EducationService {
	
	Result add(EducationDto educationDto);
	Result deleteById(int id);
	DataResult<List<Education>>getEducationListByCandidateId(int candidateId);
	DataResult<List<Education>>findAllByCandidateIdOrderByEndDateDesc(int candidateId);
}
