package kodlama.io.hrms.entities.concretes.Dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
 
	private int candidateId;
	private String schoolName;
	private String degree;
	private String schoolDepartment;
	private Date startDate;
	private Date endDate;
	private boolean isGraduated;
	private double grade;
}
