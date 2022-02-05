package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

	City getById(int id);
	
	City getByCityName(String cityName);
}
