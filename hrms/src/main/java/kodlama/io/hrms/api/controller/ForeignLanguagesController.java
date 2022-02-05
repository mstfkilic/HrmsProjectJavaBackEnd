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

import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.Dtos.ForeignLanguageDto;
@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguagesController {
	@Autowired
	private ForeignLanguageService foreignLanguageService;
	@GetMapping("/getForeignLanguageListByCandidateId")
	public DataResult<List<ForeignLanguage>> getForeignLanguageListByCandidateId(@RequestParam int candidateId){
		return this.foreignLanguageService.getForeignLanguageListByCandidateId(candidateId);
	}
	@DeleteMapping("/deleteById/{id}")
	public Result deleteById(@RequestParam int id) {
		return this.foreignLanguageService.deleteById(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguageDto foreignLanguageDto) {
		return this.foreignLanguageService.add(foreignLanguageDto);
	}
}
