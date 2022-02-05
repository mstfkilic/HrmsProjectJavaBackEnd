package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlama.io.hrms.entities.concretes.CoverLetter;
import kodlama.io.hrms.entities.concretes.Dtos.CoverLetterDto;
import net.bytebuddy.asm.Advice.This;
@Service
public class CoverLetterManager implements CoverLetterService {

	@Autowired
	private CoverLetterDao coverLetterDao;
	private CandidateDao candidateDao;
	
	
	

	public CoverLetterManager(CoverLetterDao coverLetterDao,CandidateDao candidateDao) {
		super();
		this.coverLetterDao = coverLetterDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<CoverLetter> getByCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getByCandidateId(candidateId),"CV's object is brought. ");
	}

	@Override
	public Result deleteById(int id) {
	
		
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("Cover Letter is deleted from database.");
	}

	@Override
	public Result add(CoverLetterDto coverLetterDto) {
		
		CoverLetter coverLetter = this.coverLetterDtoConvertCoverLetter(coverLetterDto);
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover Letter is saved to database.");
		
	}
	
	private  CoverLetter coverLetterDtoConvertCoverLetter(CoverLetterDto coverLetterDto) {
		CoverLetter coverLetter = new CoverLetter();
		coverLetter.setCandidate(this.candidateDao.getById(coverLetterDto.getCandidateId()));
		coverLetter.setText(coverLetterDto.getText());
		return coverLetter;
	}
	@Override
	public Result update(int candidateId, String text) {
		
		CoverLetter coverLetter = coverLetterDao.getByCandidateId(candidateId);
		coverLetter.setText(text);
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover letter is updated");
		
	}

}
