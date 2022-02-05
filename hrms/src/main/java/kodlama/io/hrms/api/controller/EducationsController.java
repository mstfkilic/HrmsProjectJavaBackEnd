package kodlama.io.hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.Dtos.EducationDto;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {

	private EducationService educationService;

	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationDto educationDto) {
		return this.educationService.add(educationDto);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Result deleteById(@RequestParam int id) {
		return this.educationService.deleteById(id);
	}
	@GetMapping("/getEducationListByCandidateId")
	public DataResult<List<Education>>getEducationListByCandidateId(@RequestParam int candidateId){
		return this.educationService.getEducationListByCandidateId(candidateId);
	}
	@GetMapping("/findAllByCandidateIdOrderByEndDateDesc")
	public DataResult<List<Education>>findAllByCandidateIdOrderByEndDateDesc(@RequestParam int candidateId){
		return this.educationService.findAllByCandidateIdOrderByEndDateDesc(candidateId);
	}
}
