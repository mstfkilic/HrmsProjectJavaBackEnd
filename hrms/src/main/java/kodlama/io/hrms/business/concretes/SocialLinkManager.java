package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SocialLinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.SocialLinkDao;
import kodlama.io.hrms.entities.concretes.SocialLink;
import kodlama.io.hrms.entities.concretes.Dtos.SocialLinkDto;

@Service
public class SocialLinkManager implements SocialLinkService {

	@Autowired
	private SocialLinkDao socialLinkDao;
	private CandidateDao candidateDao;
	
	
	public SocialLinkManager(SocialLinkDao socialLinkDao, CandidateDao candidateDao) {
		super();
		this.socialLinkDao = socialLinkDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<SocialLink> getByCandidateId(int candidateId) {
		return new SuccessDataResult<SocialLink>(this.socialLinkDao.getByCandidateId(candidateId),"Social links are listed");
	}

	@Override
	public Result deleteById(int id) {
		// TODO Auto-generated method stub
		this.socialLinkDao.deleteById(id);
		return new SuccessResult("The social link is deleted from database");
	}

	@Override
	public Result add(SocialLinkDto socialLinkDto) {
		SocialLink socialLink = this.socialLinkDtoConvertSocialLink(socialLinkDto);
		this.socialLinkDao.save(socialLink);
		return new SuccessResult("Social link is added to database");
	}
	
	private SocialLink socialLinkDtoConvertSocialLink(SocialLinkDto socialLinkDto) {
		SocialLink socialLink = new SocialLink();
		socialLink.setCandidate(this.candidateDao.getById(socialLinkDto.getCandidateId()));
		socialLink.setGithubLink(socialLinkDto.getGithubLink());
		socialLink.setLinkedinLink(socialLinkDto.getLinkedinLink());
		return socialLink;
	}

	@Override
	public Result update(int candidateId, String githubLink, String linkedinLink) {
		SocialLink socialLink = this.socialLinkDao.getByCandidateId(candidateId);
		
		socialLink.setGithubLink(githubLink);
		socialLink.setLinkedinLink(linkedinLink);
		
		this.socialLinkDao.save(socialLink);
		
		return new SuccessResult("Github link and linked link are updated");
	}

}
