package kodlama.io.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

import kodlama.io.hrms.entities.concretes.Dtos.PhotoDto;

public interface PhotoService {
	DataResult<String> getPhotoUrlByCandidateId(int candidateId);
	Result delete(int id) throws IOException;
	Result add(MultipartFile multipartFile, int id);
}
