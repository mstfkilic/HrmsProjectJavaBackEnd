package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.SkillDao;
import kodlama.io.hrms.entities.concretes.Skill;
import kodlama.io.hrms.entities.concretes.Dtos.SkillDto;

@Service
public class SkillManager implements SkillService {

	@Autowired
	private SkillDao skillDao;
	private CandidateDao candidateDao;
	
	public SkillManager(SkillDao skillDao, CandidateDao candidateDao) {
		super();
		this.skillDao = skillDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Skill>> getSkillListByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<Skill>>(this.skillDao.getSkillListByCandidateId(candidateId),"The skills of candidates are listed");
	
	}

	@Override
	public Result deleteById(int id) {
		this.skillDao.deleteById(id);
		return new SuccessResult("The skill is deleted from database");
	}
	@Override
	public Result add(SkillDto skillDto) {
		
		Skill skill = this.skillDtoConvertSkill(skillDto);
		this.skillDao.save(skill);
		return new SuccessResult("The skill is added to database");
	}
	
	private Skill skillDtoConvertSkill(SkillDto skillDto) {
		Skill skill = new Skill();
		skill.setCandidate(this.candidateDao.getById(skillDto.getCandidateId()));
		skill.setNameOfProgramming(skillDto.getName());
		return skill;
	}

}
