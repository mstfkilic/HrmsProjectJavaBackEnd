package kodlama.io.hrms.entities.concretes.Dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceDto {
	private int candidateId;
	private String businessName;
	private String jobPositionName;
	private Date startDate;
	private Date endDate;
	private boolean isContinue;
}
