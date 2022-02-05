package kodlama.io.hrms.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.PhotoService;
import kodlama.io.hrms.core.adapters.abstracts.CloudService;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.PhotoDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Photo;
import kodlama.io.hrms.entities.concretes.Dtos.PhotoDto;import net.bytebuddy.asm.Advice.This;

@Service
public class PhotoManager implements PhotoService {

	@Autowired
	private PhotoDao photoDao;
	private CandidateDao candidateDao;
	private CloudService cloudService;
	
	
	public PhotoManager(PhotoDao photoDao, CandidateDao candidateDao,CloudService cloudService) {
		super();
		this.photoDao = photoDao;
		this.candidateDao = candidateDao;
		this.cloudService = cloudService;
	}

	@Override
	public DataResult<String> getPhotoUrlByCandidateId(int candidateId) {
		Photo photo = this.photoDao.getByCandidateId(candidateId);
		return new SuccessDataResult<String>(photo.getPhotoUrl(),"Candidates photo is listed");
	}

	
	@Override
	public Result add(MultipartFile multipartFile,int id) {

		var result = this.cloudService.upload(multipartFile);
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		Candidate candidate = this.candidateDao.getById(id);
		Photo photo = new Photo();
		photo.setCandidate(candidate);
		photo.setPhotoUrl(result.getData().get("url"));
		this.photoDao.save(photo);
		return new SuccessResult("photo added");
	}

	@Override
	public Result delete(int id) throws IOException {
		this.candidateDao.deleteById(id);
		return new SuccessResult("Photo is deleted from database");
	}

}
