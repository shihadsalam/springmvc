package com.webapp.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.webapp"})
@EnableJpaRepositories(basePackages = {"com.webapp.repositories"})
public class AppConfiguration extends WebMvcConfigurerAdapter{
	
	private JndiTemplate jndiTemplate = new JndiTemplate();

	public DataSource dataSource() {
		DataSource dataSource = null;
		try {
			dataSource = jndiTemplate.lookup("java:comp/env/jdbc/mysqldb", DataSource.class);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setShowSql(false);
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setJpaProperties(jpaProperties());
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.webapp.model", "com.webapp.config", "com.webapp.services", "com.webapp.repositories");
		return entityManagerFactory;
	}
	
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory()
				.getObject());
		return jpaTransactionManager;
	}

	private Properties jpaProperties() {
		Properties props = new Properties();
		props.put("hibernate.connection.charSet", "UTF-8");
		props.put("hibernate.show_sql", false);
		props.put("hibernate.format_sql", false);
		props.put("hibernate.jdbc.batch_size", 0);
		return props;
	}

}
