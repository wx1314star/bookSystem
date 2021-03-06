package com.keluoluo.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.keluoluo.www.example.HttpFilter;
import com.keluoluo.www.example.HttpInterceptor;

@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean httpFilter() {
		FilterRegistrationBean reBean = new FilterRegistrationBean();
		reBean.setFilter(new HttpFilter());
		reBean.addUrlPatterns("/threadLocal/*");
		return reBean;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
	}

}
