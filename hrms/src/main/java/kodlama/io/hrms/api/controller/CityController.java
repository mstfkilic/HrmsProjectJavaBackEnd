package kodlama.io.hrms.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return this.cityService.add(city);
		
	}
}
