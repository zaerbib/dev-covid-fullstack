package com.covid.dev.util.runner;

import com.covid.dev.annotation.TrackTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.covid.dev.clienthttp.HttpGetDataFiles;
import com.covid.dev.util.HttpCovidURL;
import com.covid.dev.util.SystemUtils;
import com.covid.dev.util.event.AfterReadyEvent;

@Component
public class FileGetRunner {
	@Autowired
	private HttpGetDataFiles runner;
	
	@Autowired
	private SystemUtils systemUtils;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	private Logger logger = LoggerFactory.getLogger(FileGetRunner.class);
	
	@EventListener(ApplicationReadyEvent.class)
	public void getFilesRunner() {
		
		logger.info("---- début téléchargement ----");
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_AGE_FRA, systemUtils.getEntrepo1());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_REG, systemUtils.getEntrepo2());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_TXAD_FRA, systemUtils.getEntrepo3());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSP_AD_AGE, systemUtils.getEntrepo4());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSPIT_INCID_REG, systemUtils.getEntrepo5());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSPIT, systemUtils.getEntrepo6());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSPIT_INCID, systemUtils.getEntrepo7());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSPIT_CLAGE10, systemUtils.getEntrepo8());
		runner.downloadFromSource(HttpCovidURL.COVID_HOSPIT_ETAB, systemUtils.getEntrepo9());
		logger.info("---- fin téléchargement ----");
		
		logger.info("---- publication d'un event ----");
		applicationEventPublisher.publishEvent(new AfterReadyEvent(this, "after event ready"));
		logger.info("---- fin publication d'un event ----");
	}
}
