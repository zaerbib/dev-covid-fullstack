package com.covid.dev.clienthttp;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HttpGetDataFiles {
	
	@Autowired
	private RestTemplateBuilder restTemplate; 
	
	public void downloadFromSource(String source, String entrepo) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
			HttpEntity<String> entity = new HttpEntity<>(headers);
			
			ResponseEntity<byte[]> response = restTemplate.build().exchange(source, HttpMethod.GET, entity, byte[].class);
			Files.write(Paths.get(entrepo), response.getBody());
			log.info("Download {} from data.gouv to {} !", source, entrepo);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
