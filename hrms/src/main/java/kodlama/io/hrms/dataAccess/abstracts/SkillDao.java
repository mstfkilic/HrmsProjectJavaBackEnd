package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{

	List<Skill> getSkillListByCandidateId(int candidateId);
	Skill deleteById(int id);
}
