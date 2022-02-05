package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.Dtos.JobExperienceDto;

public interface JobExperienceService {

	DataResult<List<JobExperience>>getJobExperienceListByCandidateId(int candidateId);
	DataResult<List<JobExperience>>findAllByCandidateIdOrderByEndDateDesc(int candidateId);
	Result add(JobExperienceDto jobExperienceDto);
	Result deleteById(int id);
}
