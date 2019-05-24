package com.ranx.xlogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XlogsApplication {


	public static void main(String[] args) {
		SpringApplication.run(XlogsApplication.class, args);
        AbsLog log4jref = new Log4jRef();
		AbsLog log4j2ref = new Log4j2Ref();
        AbsLog logback = new LogBackRef();
		try {
//		    log4jref.fixedPringting();
//            log4j2ref.fixedPringting();
            logback.fixedPringting();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
