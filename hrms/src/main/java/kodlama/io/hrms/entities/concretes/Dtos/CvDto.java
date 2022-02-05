package kodlama.io.hrms.entities.concretes.Dtos;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.CoverLetter;
import kodlama.io.hrms.entities.concretes.Education;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.Skill;
import kodlama.io.hrms.entities.concretes.SocialLink;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CvDto {

	private Candidate candidate;
	private List<Education>educations;
	private List<JobExperience> jobExperiences;
	private List<ForeignLanguage>foreignLanguages;
	private List<SocialLink>socialLinks;
	private List<Skill>skills;
	private CoverLetter coverLetter; 
	
}
