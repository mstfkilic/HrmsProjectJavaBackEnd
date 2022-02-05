package kodlama.io.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CoverLetter;
import kodlama.io.hrms.entities.concretes.Dtos.CoverLetterDto;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {

	@Autowired
	private CoverLetterService coverLetterService;

	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterDto coverLetterDto) {
		return this.coverLetterService.add(coverLetterDto);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Result delete(@RequestParam int id) {
		return this.coverLetterService.deleteById(id);
	}
	@PutMapping("/update")
	public Result update(@RequestParam int candidateId,@RequestParam String text) {
		return this.coverLetterService.update(candidateId, text);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<CoverLetter>getByCandidateId(@RequestParam int candidateId){
		return this.coverLetterService.getByCandidateId(candidateId);
	}
	
	
}
