package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Integer> {
	
	List<Employer>findByEmail(String email);
	List<Employer>findByEmailIgnoreCase(String email);
	List<Employer>findByWebAddressIgnoreCase(String webAddress);
	List<Employer>findEmployerById(int id);
	List<Employer>findEmployerByCompanyName(String companyName);
}
