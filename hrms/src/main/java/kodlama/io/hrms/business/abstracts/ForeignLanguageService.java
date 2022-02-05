package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.Dtos.ForeignLanguageDto;

public interface ForeignLanguageService {
	DataResult<List<ForeignLanguage>> getForeignLanguageListByCandidateId(int candidateId);
	Result deleteById(int id);
	Result add(ForeignLanguageDto foreignLanguageDto);
}
