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

import kodlama.io.hrms.business.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Skill;
import kodlama.io.hrms.entities.concretes.Dtos.SkillDto;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {
	@Autowired
	private SkillService skillService;
	
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	@GetMapping("/getSkillListByCandidateId")
	
	public DataResult<List<Skill>> getSkillListByCandidateId(@RequestParam int candidateId){
		return this.skillService.getSkillListByCandidateId(candidateId);
	}
	@DeleteMapping("/deleteById/{id}")
	public Result deleteById(int id) {
		return this.skillService.deleteById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SkillDto skillDto) {
		return this.skillService.add(skillDto);
	}
}
