package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.SocialLink;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer>{

	SocialLink getByCandidateId(int candidateId);
	SocialLink deleteById(int id);
}
