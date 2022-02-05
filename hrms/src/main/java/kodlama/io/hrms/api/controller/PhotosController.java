package kodlama.io.hrms.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.PhotoService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Dtos.PhotoDto;

@RestController
@RequestMapping("/api/photos")
public class PhotosController {
	@Autowired
	private PhotoService photoService;
	
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	@GetMapping("/getPhotoUrlByCandidateId")
	public DataResult<String> getPhotoUrlByCandidateId(@RequestParam int candidateId){
		return this.photoService.getPhotoUrlByCandidateId(candidateId);
	}
	@PostMapping("/add")
	public Result add(@RequestParam MultipartFile multipartFile,@RequestParam int id) {
		return this.photoService.add(multipartFile,id);
	}
	@DeleteMapping("/delete")
	public Result delete(int id) throws IOException {
		return this.photoService.delete(id);
	}
}
