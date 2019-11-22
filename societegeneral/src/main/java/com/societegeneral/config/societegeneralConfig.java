/*
 Author by Ravishankar 
 */
package com.societegeneral.config;


import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ComponentScan(basePackages = "com.societegeneral")
@EnableTransactionManagement
public class societegeneralConfig {
		@Bean
	    @Primary
	    public DataSource dataSource() {
	    	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    	//BasicDataSource dataSource = new BasicDataSource();
	         dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	         dataSource.setUrl("jdbc:mysql://localhost/societegeneral");
	         dataSource.setUsername("root");
	         dataSource.setPassword("root");
	         System.out.println("dataSource.getConnectionProperties() = " +dataSource.getConnectionProperties());
	//         dataSource.setConnectionProperties(jpaProperties());
	         System.out.println("User name= " +dataSource.getUsername());
	         System.out.println("password = "+dataSource.getPassword());
	         System.out.println("dataSource.getUrl()"+dataSource.getUrl());
	         return dataSource;
	    }
	
	 	@Bean
	    @Primary
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
	        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
	        factoryBean.setDataSource(dataSource());
	        factoryBean.setPackagesToScan(new String[] { "com.societegeneral" });
	       factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
	       factoryBean.setJpaProperties(jpaProperties());
	        return factoryBean;
	    }
	 
	 @Bean
	    public JpaVendorAdapter jpaVendorAdapter() {
	        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	        return hibernateJpaVendorAdapter;
	    }  private Properties jpaProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        properties.put("hibernate.hbm2ddl.auto", "create");
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.format_sql","true");
	        properties.put("javax.persistence.validation.mode","none");
	        //properties.put("update", "create");
	      //  properties.setProperty("useSSL", "false");
	        //properties.setProperty("autoReconnect", "true");
	        return properties;
	    }
	 
	    @Bean
	    @Autowired
	    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	        JpaTransactionManager txManager = new JpaTransactionManager();
	        txManager.setEntityManagerFactory(emf);
	        return txManager;
	    }


}
