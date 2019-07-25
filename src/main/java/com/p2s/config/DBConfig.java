package com.p2s.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.p2s.repository")
@PropertySource("classpath:database.properties")
public class DBConfig {

	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_DIALECT = "hibernate.dialect";

	@Autowired
	Environment environment;

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		lfb.setDataSource(dataSource());
		lfb.setPersistenceProviderClass(HibernatePersistence.class);
		lfb.setPackagesToScan("com.p2s.model");
		lfb.setJpaProperties(hibernateProps());
		return lfb;
	}

	@Bean
	DataSource dataSource() throws NamingException {
		return (DataSource) new JndiTemplate().lookup(environment.getProperty(PROPERTY_URL));
	}

	Properties hibernateProps() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
		properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
		return properties;
	}

	@Bean
	JpaTransactionManager transactionManager() throws NamingException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
