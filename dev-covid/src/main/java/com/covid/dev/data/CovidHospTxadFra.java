package com.covid.dev.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "covid_hosp_txad_fra")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Data
public class CovidHospTxadFra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "txadFra_generator")
	private Long id;
	private String fra;
	private Integer strate2;
	private LocalDate jour;
	
	@Column(name = "PourAvec")
	private Integer pourAvec;
	@Column(name = "tx_indic_7J_DC")
	private Double txIndic7JDc;
	@Column(name = "tx_indic_7J_hosp")
	private Double txIndic7JHosp;
	@Column(name = "tx_indic_7J_SC")
	private Double txIndic7JSc;
	@Column(name = "tx_prev_hosp")
	private Double txPrevHosp;
	@Column(name = "tx_prev_SC")
	private Double txPrevSc;
	@Column(insertable = true, name = "updateTime")
	private LocalDateTime updateTime;

	@PrePersist
	public void onCreate() {
		this.setUpdateTime(LocalDateTime.now());
	}
	
}
