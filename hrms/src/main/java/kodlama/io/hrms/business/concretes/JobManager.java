package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobDao;
import kodlama.io.hrms.entities.concretes.Job;
import kodlama.io.hrms.entities.concretes.Dtos.JobPositionDto;


@Service
public class JobManager implements JobService {

	@Autowired
	private JobDao jobDao;
	
	

	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"All jobs are listed");
	}
	
	public Result isPositonNameExist(String positionName) {
		if(jobDao.getByPositionName(positionName)!= null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public Result add(JobPositionDto jobPositionDto) throws Exception {
		// TODO Auto-generated method stub
		if(this.isPositonNameExist(jobPositionDto.getTitle()).isSuccess()) {
			return new ErrorResult("Titles already exist");
		}
		
		Job job =  this.jobPositionDtoConvertJob(jobPositionDto);
		this.jobDao.save(job);
		return new SuccessResult("The job title is added");
	}
	
	private Job jobPositionDtoConvertJob(JobPositionDto jobPositionDto) {
		Job job = new Job();
		job.setPositionName(jobPositionDto.getTitle());
		return job;
	}
}
