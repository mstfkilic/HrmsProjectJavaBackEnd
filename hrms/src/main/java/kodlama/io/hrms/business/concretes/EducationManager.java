package kodlama.io.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.Dtos.EducationDto;
@Service
public class EducationManager implements EducationService{
	
	@Autowired
	private EducationDao educationDao;
	private CandidateDao candidateDao;
	
	public EducationManager(EducationDao educationDao,CandidateDao candidateDao) {
		super();
		this.educationDao = educationDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result deleteById(int id) {
		this.educationDao.deleteById(id);
		
		return new SuccessResult("Deleted from database");
	}

	@Override
	public DataResult<List<Education>> getEducationListByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<Education>>(this.educationDao.getEducationListByCandidateId(candidateId),"Education list are listed regarding Candidate.");
	}

	@Override
	public DataResult<List<Education>> findAllByCandidateIdOrderByEndDateDesc(int candidateId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByCandidateIdOrderByEndDateDesc(candidateId),"Educations are listed regarding end date as descending");
	}

	@Override
	public Result add(EducationDto educationDto) {
		
		Education education = this.EducationDtoConvertEducation(educationDto);
		this.educationDao.save(education);
		return new SuccessResult("Education added to system.");
	}
	
	private Education  EducationDtoConvertEducation(EducationDto educationDto) {
		Education education = new Education();
		education.setCandidate(this.candidateDao.getById(educationDto.getCandidateId()));
		education.setDegree(educationDto.getDegree());
		education.setEndDate(new Date());
		education.setGrade(educationDto.getGrade());
		education.setId(educationDto.getCandidateId());
		education.setIsGraduated(educationDto.isGraduated());
		education.setSchoolDepartment(educationDto.getSchoolDepartment());
		education.setSchoolName(educationDto.getSchoolName());
		education.setStartDate(new Date());
		
		return education;
	}

}
