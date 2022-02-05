package kodlama.io.hrms.business.concretes;

import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CityDao;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.dataAccess.abstracts.JobDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.concretes.Dtos.JobAdvertisementDto;


@Service


public class JobAdvertisementManager implements JobAdvertisementService{

	@Autowired
	private JobAdvertisementDao jobAdvertisementDao;
	private CityDao cityDao;
	private JobDao jobDao;
	private EmployerDao employerDao;
	
	
	
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityDao cityDao, JobDao jobDao,
			EmployerDao employerDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityDao = cityDao;
		this.jobDao = jobDao;
		this.employerDao = employerDao;
	}

	@Override
	public Result getById(int id) {
		
		this.jobAdvertisementDao.getById(id);
		return new SuccessResult("Data are listed");
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisement() {
		// TODO Auto-generated method stub
			return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActiveJobAdvertisement(),"Active Job Advertisement are listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByAllActiveByEmployer(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByAllActiveByEmployer(employerId),"Active Job Advertisement are Listed by Employer ");
	}

	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		
		JobAdvertisement jobAdvertisement = this.jobAdDtoConvertJobAd(jobAdvertisementDto);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added to system.");
		
		
	}
	
	private JobAdvertisement jobAdDtoConvertJobAd(JobAdvertisementDto jobAdvertisementDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setApplicationDeadLine(jobAdvertisementDto.getApplicationDeadLine());
		jobAdvertisement.setCity(this.cityDao.getById(jobAdvertisementDto.getCityId()));
		jobAdvertisement.setCreationDate(new Date());
		jobAdvertisement.setEmployer(this.employerDao.getById(jobAdvertisementDto.getEmployerId()));
		jobAdvertisement.setJob(this.jobDao.getById(jobAdvertisementDto.getJobPositionId()));
		jobAdvertisement.setJobDescription(jobAdvertisementDto.getDescription());
		jobAdvertisement.setMaxSalary(jobAdvertisementDto.getMaxSalary());
		jobAdvertisement.setMinSalary(jobAdvertisementDto.getMinSalary());
		jobAdvertisement.setNumberOfOpenPositions(jobAdvertisementDto.getNumberOfOpenPosition());
		
		jobAdvertisement.setActive(false);
		
		return jobAdvertisement;
	}

	@Override
	public Result setActivation(int id) {
		// TODO Auto-generated method stub
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		if(!(jobAdvertisement.getId()==id)) {
			return new ErrorResult("There is no like advertisement");
		}else {
		jobAdvertisement.setActive(true);
		return new SuccessResult("Advertisement active");
		}
	}

	@Override
	public Result passiveActivation(int id) {
		// TODO Auto-generated method stub
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		jobAdvertisement.setActive(false);
		return new SuccessResult("Advertisement passive");
	}

	@Override
	
	public Result deleteByEmployerId(int employerId) {
		this.jobAdvertisementDao.deleteByEmployerId(employerId);
		return new SuccessResult("The advertisement is deleted from database");
	}

}
