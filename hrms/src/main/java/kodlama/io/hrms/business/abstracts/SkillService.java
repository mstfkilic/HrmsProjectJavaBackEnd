package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Skill;
import kodlama.io.hrms.entities.concretes.Dtos.SkillDto;

public interface SkillService {
	DataResult<List<Skill>> getSkillListByCandidateId(int candidateId);
	Result deleteById(int id);
	Result add(SkillDto skillDto);
}
