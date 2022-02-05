package kodlama.io.hrms.api.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.Dtos.EmployerDtoForRegister;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>>getAll(){
		return this.employerService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody EmployerDtoForRegister employerDtoForRegister) throws Exception {
		return this.employerService.add(employerDtoForRegister);
	}
	@DeleteMapping("/delete/{employerId}")
	public Result delete(@RequestParam int employerId) {
		return this.employerService.delete(employerId);
	}
	@PutMapping("/update/{employerId}")
	public DataResult<Employer>update(@RequestParam int employerId,@RequestBody Employer employerInfo){
		return this.employerService.update(employerId, employerInfo);
	}
	
}
