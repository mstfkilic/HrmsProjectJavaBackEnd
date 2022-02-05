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

import kodlama.io.hrms.business.abstracts.SocialLinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.SocialLink;
import kodlama.io.hrms.entities.concretes.Dtos.SocialLinkDto;

@RestController
@RequestMapping("/api/sociallinks")


public class SocialLinksController {
	@Autowired
	private SocialLinkService socialLinkService;
	public SocialLinksController(SocialLinkService socialLinkService) {
		super();
		this.socialLinkService = socialLinkService;
	}
	@GetMapping("/getByCandidateId")
	public DataResult<SocialLink> getByCandidateId(@RequestParam int candidateId){
		return this.socialLinkService.getByCandidateId(candidateId);
	}
	@DeleteMapping("/deleteById/{id}")
	public Result deleteById(@RequestParam int id) {
		return this.socialLinkService.deleteById(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody SocialLinkDto socialLinkDto) {
		return socialLinkService.add(socialLinkDto);
	}
	@PutMapping("/update")
	public Result update(@RequestParam int candidateId,@RequestParam String githubLink,@RequestParam String linkedinLink) {
		return this.socialLinkService.update(candidateId, githubLink, linkedinLink);
	}
}
