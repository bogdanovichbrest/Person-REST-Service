package jp.hanazono.config;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="jp.hanazono")
public class Config {

	@Bean
	public AutowiredAnnotationBeanPostProcessor postProcessor() {
		return new AutowiredAnnotationBeanPostProcessor();
	}

	@Bean(name = "PersonDataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:~/test");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;

	}

	//@Bean
	//public UrlBasedViewResolver setupResolver() {
		//UrlBasedViewResolver resolver = new UrlBasedViewResolver();
       // resolver.setPrefix("/pages/");
       // resolver.setSuffix(".jsp");
        //resolver.setViewClass(JstlView.class);
		//return resolver;
//	}

}
