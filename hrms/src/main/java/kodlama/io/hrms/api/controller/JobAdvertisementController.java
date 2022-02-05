package kodlama.io.hrms.api.controller;

import java.util.Date;
import java.util.List;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.concretes.Dtos.JobAdvertisementDto;

@RequestMapping("/api/jobadvertisements")
@RestController
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;
	
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getById")
	public Result getById(int id) {
		
		return this.jobAdvertisementService.getById(id);
		
	}
	
	@GetMapping("/getAllActiveJobAdvertisement")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisement() {
		
		return this.jobAdvertisementService.getAllActiveJobAdvertisement();
	}

	@GetMapping("/getAllActiveJobAdvertisement/{employerId}")
	public DataResult<List<JobAdvertisement>> getAllActiveByEmployer(@RequestParam int employerId) {
		
		return this.jobAdvertisementService.getByAllActiveByEmployer(employerId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisementDto) {
		
		return this.jobAdvertisementService.add(jobAdvertisementDto);
	}
	
	@PostMapping("/setActivation/{id}")
	public Result setActivation(@RequestParam int id) {
		return this.jobAdvertisementService.setActivation(id);
	}

	@PostMapping("/passiveActivation/{id}")
	public Result passiveActivation(int id) {
		return this.jobAdvertisementService.passiveActivation(id);
	}
	@DeleteMapping("/deleteByEmployerId/{employerId}")
	public Result deleteByEmployerId(@RequestParam int employerId) {
		return this.jobAdvertisementService.deleteByEmployerId(employerId);
	}

}
