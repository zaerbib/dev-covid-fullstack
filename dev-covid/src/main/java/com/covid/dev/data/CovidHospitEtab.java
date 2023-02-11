package com.covid.dev.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "covid_hosp_etab")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Data
public class CovidHospitEtab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etab_generator")
	private Long id;
	private Integer dep;
	private LocalDate jour;
	private Integer nb;

	@Column(insertable = true, name = "updateTime")
	private LocalDateTime updateTime;

	@PrePersist
	public void onCreate() {
		this.setUpdateTime(LocalDateTime.now());
	}
}
