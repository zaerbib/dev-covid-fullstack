package com.covid.dev.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "covid_hospit_incid_reg")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Data
public class CovidHospitIncidReg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_generator")
	private Long id;
	private LocalDate jour;
	private String nomReg;
	private Integer numReg;
	@Column(name = "incid_rea")
	private String incidRea;

	@Column(insertable = true, name="updateTime")
	private LocalDateTime updateTime;

	@PrePersist
	public void onCreate(){
		this.setUpdateTime(LocalDateTime.now());
	}
}
