package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.SocialLink;
import kodlama.io.hrms.entities.concretes.Dtos.SocialLinkDto;

public interface SocialLinkService {
	DataResult<SocialLink> getByCandidateId(int candidateId);
	Result deleteById(int id);
	Result add(SocialLinkDto socialLinkDto);
	Result update(int candidateId,String githubLink,String linkedinLink);
}
