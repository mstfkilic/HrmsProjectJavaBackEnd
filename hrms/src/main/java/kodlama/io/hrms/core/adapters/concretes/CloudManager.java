package kodlama.io.hrms.core.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.adapters.abstracts.CloudService;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;

@Component
public class CloudManager implements CloudService {

	
	private final Cloudinary cloudinary;
	
	@Autowired
	public CloudManager() {
		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				
				"cloud_name","dlov3rcul",
				"api_key","547256699221247",
				"api_secret","kqN4NW_3fixavIrZUmJrZnhj2MU"
				
				));
	}

	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
		File file;
		try {
			file = convert(multipartFile);
			Map<String,String>result = cloudinary.uploader().upload(file,ObjectUtils.emptyMap());
			file.delete();
			return new SuccessDataResult<>(result);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<>("File is not loaded");
		}
		
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
		return new SuccessDataResult<>(result);	
		}
	
	private File convert(MultipartFile multipartFile) throws IOException{
		
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		return file;
	}

	
	
	
	
}

	
	


