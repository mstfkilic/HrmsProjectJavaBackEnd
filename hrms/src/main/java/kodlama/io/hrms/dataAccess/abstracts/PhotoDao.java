package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer>{

	Photo getByCandidateId(int candidateId);
	Photo getPhotoUrlByCandidateId(int candidateId);
}
