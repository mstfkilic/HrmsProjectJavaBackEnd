package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.Dtos.ForeignLanguageDto;
@Service
public class ForeignLanguageManager implements ForeignLanguageService {
	
	@Autowired
	private ForeignLanguageDao foreignLanguageDao;
	private CandidateDao candidateDao;
	
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao, CandidateDao candidateDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<ForeignLanguage>> getForeignLanguageListByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.getForeignLanguageListByCandidateId(candidateId),"All foreign languages of candidates are listed");
	}

	@Override
	public Result deleteById(int id) {
		this.foreignLanguageDao.deleteById(id);
		return new SuccessResult("The languages are removed from datanbase");
	}

	@Override
	public Result add(ForeignLanguageDto foreignLanguageDto) {
		ForeignLanguage foreignLanguage = this.foreignLanguageDtoConvertForeignLanguage(foreignLanguageDto);
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("The language are saved to database");
	}
	
	private ForeignLanguage foreignLanguageDtoConvertForeignLanguage(ForeignLanguageDto foreignLanguageDto) {
		
		ForeignLanguage foreignLanguage = new ForeignLanguage();
		foreignLanguage.setCandidate(this.candidateDao.getById(foreignLanguageDto.getCandidateId()));
		foreignLanguage.setLanguage(foreignLanguageDto.getLanguage());
		foreignLanguage.setLanguageLevel(foreignLanguage.getLanguageLevel());
		
		
		return foreignLanguage;
		
	}

}
