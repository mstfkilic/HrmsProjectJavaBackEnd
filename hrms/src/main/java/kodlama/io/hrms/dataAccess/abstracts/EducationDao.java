package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

	List<Education>getEducationListByCandidateId(int candidateId);
	List<Education>findAllByCandidateIdOrderByEndDateDesc(int candidateId);
	Education deleteById(int id);
}
