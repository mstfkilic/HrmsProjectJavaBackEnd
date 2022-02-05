package kodlama.io.hrms.entities.concretes.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialLinkDto {
	private int candidateId;
	private String githubLink;
	private String linkedinLink;
}
