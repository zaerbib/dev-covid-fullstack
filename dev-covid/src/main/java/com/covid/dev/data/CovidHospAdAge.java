package com.covid.dev.data;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDateTime;

@Entity
@Table(name = "covid_hosp_ad_age")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Data
public class CovidHospAdAge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adAge_generator")
	private Long id;
	private Integer reg;
	@Column(name = "Semaine")
	private String semaine;
	@Column(name = "cl_age90")
	private Integer clage90;
	@Column(name = "NewAdmHospit")
	private String newAdmHospit;

	@Column(insertable = true, name = "updateTime")
	private LocalDateTime updatetime;

	@PrePersist
	public void onCreate() {
		this.setUpdatetime(LocalDateTime.now());
	}
}
