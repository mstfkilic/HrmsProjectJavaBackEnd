package kodlama.io.hrms.business.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CityDao;
import kodlama.io.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	@Autowired
	private CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	@Override
	public Result add(City city) {
		
		this.cityDao.save(city);
		return new SuccessResult("City is added to system");
	}

}
