package kodlama.io.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.Dtos.JobExperienceDto;
@Service
public class JobExperienceManager implements JobExperienceService{
	@Autowired
	private JobExperienceDao jobExperienceDao;
	private CandidateDao candidateDao;
	
	public JobExperienceManager(JobExperienceDao jobExperienceDao, CandidateDao candidateDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<JobExperience>> getJobExperienceListByCandidateId(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getJobExperienceListByCandidateId(candidateId),"Candidate's Job Experience are listed");
	}

	@Override
	public DataResult<List<JobExperience>> findAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByCandidateIdOrderByEndDateDesc(candidateId),"Job Experience are listed regarding End Date");
	}

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		JobExperience jobExperience = this.jobExperienceDtoConvertJobExperience(jobExperienceDto);
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Job Experience are added to database");
	}
	
	private JobExperience jobExperienceDtoConvertJobExperience(JobExperienceDto jobExperienceDto) {
		JobExperience jobExperience = new JobExperience();
		jobExperience.setBusinessName(jobExperienceDto.getBusinessName());
		jobExperience.setCandidate(this.candidateDao.getById(jobExperienceDto.getCandidateId()));
		jobExperience.setContinue(false);
		jobExperience.setEndDate(new Date());
		
		jobExperience.setJobPositionName(jobExperienceDto.getJobPositionName());
		jobExperience.setStartDate(new Date());
		
		
		return jobExperience;
	}

	@Override
	public Result deleteById(int id) {
		this.jobExperienceDao.deleteById(id);
		return new SuccessResult("The job experience are removed from database");
	}

}
