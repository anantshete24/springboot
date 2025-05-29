package com.lcwd.db.postgres.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="secondEntityManagerFactoryBean", 
					   basePackages= {"com.lcwd.db.postgres.repo"},
					   transactionManagerRef="secondTransactionManager")
public class PostgresDbConfig {

	@Autowired
	
	private Environment enviornment;
	
	//datasource
	@Bean(name="secondDataSource") 
	@Primary
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(enviornment.getProperty("spring.datasource.dbcp2.url"));
		dataSource.setDriverClassName(enviornment.getProperty("spring.datasource.dbcp2.driver-class-name"));
		dataSource.setUsername(enviornment.getProperty("spring.datasource.dbcp2.username"));
		dataSource.setPassword(enviornment.getProperty("spring.datasource.dbcp2.password"));

		return dataSource;
	}
	
	//entitymanagerfactory

	@Bean(name="secondEntityManagerFactoryBean")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean bean= new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		JpaVendorAdapter adapter= new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
		bean.setPackagesToScan("com.lcwd.db.mysql.entities");
		Map<String,String> props=new HashMap<>();
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.put("hibernate.show.sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		bean.setJpaPropertyMap(props);
		bean.setPackagesToScan("com.lcwd.db.postgres.entities");
		return bean;
		
		
	}
	
	//platformTransactionManager
	
	@Bean(name="secondTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager()
	{
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return manager;
	}
}