package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_experiences")
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="business_name")
	private String businessName;
	@Column(name="job_position_name")
	private String jobPositionName;
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	@Column(name="is_continue")
	private boolean isContinue;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
