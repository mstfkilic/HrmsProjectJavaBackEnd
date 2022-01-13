package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="user_id")

@Table(name="employers")
public class Employer extends User {
	@NotBlank
	@Column(name="company_name")
	private String companyName;
	@NotBlank
	@Column(name="website_adress")
  	private String webAddress;
	@NotBlank
	@Column(name="phone_number")
	private String phoneNumber;
	
}