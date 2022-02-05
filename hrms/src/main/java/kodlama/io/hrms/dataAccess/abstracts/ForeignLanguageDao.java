package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {

	List<ForeignLanguage> getForeignLanguageListByCandidateId(int candidateId);
	ForeignLanguage deleteById(int id);
}
