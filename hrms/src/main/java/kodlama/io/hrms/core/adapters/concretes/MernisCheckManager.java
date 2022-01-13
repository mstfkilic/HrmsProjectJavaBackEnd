package kodlama.io.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.adapters.abstracts.MernisCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService{

	@Override
	public Result checkIfRealPerson(Candidate candidate) throws Exception {
		// TODO Auto-generated method stub
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),candidate.getFirstName(),candidate.getLastName(),candidate.getBirthYear());
		if(!result) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	

}
