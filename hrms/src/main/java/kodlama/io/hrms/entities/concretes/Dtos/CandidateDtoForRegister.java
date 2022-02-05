package kodlama.io.hrms.entities.concretes.Dtos;

import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDtoForRegister {

	@NotNull

	private String firstName;
	@NotNull

	private String lastName;
	
	@NotNull
	private String identityNumber;
	@NotNull
	private int birthYear;
	@NotNull
	private String email;
	@NotNull
	private String password;
}
