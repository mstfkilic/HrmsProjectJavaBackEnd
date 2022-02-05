package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="educations")
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	@Column(name="school_name")
	private String schoolName;
	@Column(name="school_department")
	private String schoolDepartment;
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	@Column(name="is_graduated")
	private Boolean isGraduated;
	@Column(name="degree")
	private String degree;
	@Column(name="grade")
	private double grade;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	}
