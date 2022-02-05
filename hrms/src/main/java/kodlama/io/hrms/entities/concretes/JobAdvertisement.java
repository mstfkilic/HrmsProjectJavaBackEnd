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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_advertisements")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job","employer","city"})
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "job_description")
	private String jobDescription;
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name = "min_salary")
	private double minSalary;
	@Column(name = "max_salary")
	private double maxSalary;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Temporal(TemporalType.DATE)
	@Column(name="application_dead_line")
	private Date applicationDeadLine;
	
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	
}