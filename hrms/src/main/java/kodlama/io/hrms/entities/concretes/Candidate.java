package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations","jobExperiences","foreignLanguages","skills","coverLetters","photos"})
@Table(name="job_seekers")
public class Candidate extends User {
	
	@NotNull
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	@NotNull
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	@NotNull
	@NotBlank
	@Size(min=11, max=11)
	@Column(name="identity_number")
	private String identityNumber;
	@NotNull
	@NotBlank
	@Column(name="birth_date")
	private int birthYear;
	@JsonManagedReference
	@OneToMany(mappedBy="candidate",fetch = FetchType.EAGER)
	private List<Education> educations;
	
	@OneToMany(mappedBy="candidate")
	private List<ForeignLanguage> foreignLanguages;
	
	@OneToMany(mappedBy="candidate")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy="candidate")
	private List<Skill> skills;
	
	@OneToOne(mappedBy="candidate")
	private SocialLink socialLink;
	
	@OneToOne(mappedBy="candidate")
	private CoverLetter coverLetter;
	
	@OneToOne(mappedBy="candidate")
	private Photo photo;
}
