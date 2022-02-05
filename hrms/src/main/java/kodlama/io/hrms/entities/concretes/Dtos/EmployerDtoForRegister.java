package kodlama.io.hrms.entities.concretes.Dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDtoForRegister {

	@NotNull
	@NotBlank
	private String companyName;
	@NotNull
	@NotBlank
	private String webAddress;
	@NotNull
	@NotBlank
	private String phoneNumber;
	@NotNull
	@NotBlank
	private String email;
	@NotNull
	@NotBlank
	private String password;

	private String passwordRepeat;
}
