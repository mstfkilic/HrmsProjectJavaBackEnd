package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	List<Candidate> getByIdentityNumber(String identityNumber);
	List<Candidate> getByEmail(String email);
	Candidate deleteById (int id);
}
