package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.hrms.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Integer> {
	
	List<Employer>getByEmail(String email);
	List<Employer>getByEmailIgnoreCase(String email);
	List<Employer>getByWebAddressIgnoreCase(String webAddress);
	List<Employer>getEmployerById(int id);
	List<Employer>getEmployerByCompanyName(String companyName);
}
