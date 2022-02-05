package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	JobAdvertisement getById(int id);
	
	@Query("from JobAdvertisement ja where ja.isActive = true")
	List<JobAdvertisement>getAllActiveJobAdvertisement();
	
	@Query("from JobAdvertisement ja where ja.employer.id=:employerId")
	List<JobAdvertisement>getByAllActiveByEmployer(int employerId);
	
	JobAdvertisement deleteByEmployerId(int employerId);
}
