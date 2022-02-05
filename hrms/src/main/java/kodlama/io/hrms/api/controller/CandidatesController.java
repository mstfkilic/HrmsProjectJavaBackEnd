package kodlama.io.hrms.api.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Dtos.CandidateDtoForRegister;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>>getAll(){
		return this.candidateService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CandidateDtoForRegister candidateDtoForRegister) throws Exception {
		return this.candidateService.add(candidateDtoForRegister);
	}
	@DeleteMapping("/deleteById/{id}")
	public Result deleteById(@RequestParam int id) {
		return this.candidateService.deleteById(id);
	}
	@PutMapping("/update/{candidateId}")
	public DataResult<Candidate>update(@RequestParam int candidateId,@RequestBody Candidate candidateInfo){
		return this.candidateService.update(candidateId, candidateInfo);
	}
	
}
