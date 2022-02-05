package kodlama.io.hrms.entities.concretes.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDto {
	private int candidateId;
	private String photoUrl;
}
