package kodlama.io.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.Dtos.JobExperienceDto;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {
	@Autowired
	private JobExperienceService jobExperienceService;
	
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	@GetMapping("/getJobExperienceListByCandidateId")
	public DataResult<List<JobExperience>>getJobExperienceListByCandidateId(@RequestParam int candidateId){
		return this.jobExperienceService.getJobExperienceListByCandidateId(candidateId);
	}
	@GetMapping("/findAllByCandidateIdOrderByEndDateDesc")
	DataResult<List<JobExperience>>findAllByCandidateIdOrderByEndDateDesc(@RequestParam int candidateId){
		return this.jobExperienceService.findAllByCandidateIdOrderByEndDateDesc(candidateId);
	}
	@PostMapping("/add")
	Result add(@RequestBody JobExperienceDto jobExperienceDto) {
		return this.jobExperienceService.add(jobExperienceDto);
	}
	@DeleteMapping("/deleteById/{id}")
	Result deleteById(@RequestParam int id) {
		return this.jobExperienceService.deleteById(id);
	}
}
