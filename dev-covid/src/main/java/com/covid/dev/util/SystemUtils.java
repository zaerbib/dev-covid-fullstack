package com.covid.dev.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemUtils {
	@Value("${entrepo.entry}")
	private String entrepo;
	
	@Value("${entrepo.data1}")
	private String entrepo1;
	
	@Value("${entrepo.data2}")
	private String entrepo2;
	
	@Value("${entrepo.data3}")
	private String entrepo3;
	
	@Value("${entrepo.data4}")
	private String entrepo4;
	
	@Value("${entrepo.data5}")
	private String entrepo5;
	
	@Value("${entrepo.data6}")
	private String entrepo6;
	
	@Value("${entrepo.data7}")
	private String entrepo7;
	
	@Value("${entrepo.data8}")
	private String entrepo8;
	
	@Value("${entrepo.data9}")
	private String entrepo9;
	
	public String getEntrepo() {
		return this.entrepo;
	}

	public String getEntrepo1() {
		return entrepo1;
	}

	public String getEntrepo2() {
		return entrepo2;
	}

	public String getEntrepo3() {
		return entrepo3;
	}

	public String getEntrepo4() {
		return entrepo4;
	}

	public String getEntrepo5() {
		return entrepo5;
	}

	public String getEntrepo6() {
		return entrepo6;
	}

	public String getEntrepo7() {
		return entrepo7;
	}

	public String getEntrepo8() {
		return entrepo8;
	}

	public String getEntrepo9() {
		return entrepo9;
	}
}
