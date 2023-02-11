package com.covid.dev.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "covid_hospit_incid")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Data
public class CovidHospitIncid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incid_generator")
	private Long id;
	private Integer dep;
	private LocalDate jour;
	
	@Column(name = "incid_hosp")
	private Integer incidHosp;
	@Column(name = "incide_rea")
	private Integer incidRea;
	@Column(name = "incid_dc")
	private Integer incidDc;
	@Column(name = "incid_rad")
	private Integer incidRad;
	@Column(insertable = true, name = "updateTime")
	private LocalDateTime updateTime;

	@PrePersist
	public void onCreate(){
		this.setUpdateTime(LocalDateTime.now());
	}
}
