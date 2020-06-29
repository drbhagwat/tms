package com.s3group.tmsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@ComponentScan("com.s3group.tmsapi.*")
public class TMSApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TMSApplication.class);

	@Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("file:" + System.getenv().get("CONF_DIR") + "/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  @Bean
  public LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(messageSource);
    return bean;
  }

  public static void main(String[] args) {
  	SpringApplication.run(TMSApplication.class, args);
		LOGGER.debug("This is a debug message");
		LOGGER.info("This is an info message");
		LOGGER.warn("This is a warn message");
		LOGGER.error("This is an error message");
	}
}
