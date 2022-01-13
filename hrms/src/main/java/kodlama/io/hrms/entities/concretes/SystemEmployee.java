package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="system_personnel")
public class SystemEmployee extends User {
	@Column(name="position_name")
	@NotNull
	private String positionName;
	@Column(name="first_name")
	@NotNull
	@NotBlank
	private String firstName;
	@NotNull
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	
}
