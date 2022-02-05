package kodlama.io.hrms.business.abstracts;

import java.util.List;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.concretes.Dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	Result getById(int id);
	
	
	DataResult<List<JobAdvertisement>>getAllActiveJobAdvertisement();
	
	
	DataResult<List<JobAdvertisement>>getByAllActiveByEmployer(int employerId);
	
	Result add(JobAdvertisementDto jobAdvertisementDto);
	
	Result setActivation(int id);
	Result passiveActivation(int id);
	
	Result deleteByEmployerId(int employerId);
}
