package kodlama.io.hrms.business.abstracts;



import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;

public interface CityService {
	
	Result add(City city);
}
