package kodlama.io.hrms.entities.concretes.Dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	
	private String description;
	
	private int employerId;
	
	private int cityId;
	
	private int jobPositionId;
	
	private double minSalary;
	private double maxSalary;
	private int numberOfOpenPosition;
	private Date applicationDeadLine;
	private Date creationDate;
	
}
