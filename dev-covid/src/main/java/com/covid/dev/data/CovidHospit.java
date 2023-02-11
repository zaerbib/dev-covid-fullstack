package com.covid.dev.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "covid_hospit")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Data
public class CovidHospit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospit_generator")
	private Long id;
	private String dep;
	private Character sex;
	private LocalDate jour;
	private Integer hosp;
	private Integer rea;
	@Column(name = "HospConv")
	private Integer hospConv;
	@Column(name = "SSR_USLD")
	private Integer ssrUsld;
	private Integer autres;
	private Integer rad;
	private Integer dc;
	@Column(insertable = true, name = "updateTime")
	private LocalDateTime updateTime;

	@PrePersist
	public void onCreate(){
		this.setUpdateTime(LocalDateTime.now());
	}
}
