package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Job;
import kodlama.io.hrms.entities.concretes.Dtos.JobPositionDto;

public interface JobService {
	DataResult<List<Job>>getAll();
	Result add(JobPositionDto jobPositionDto) throws Exception;
}
