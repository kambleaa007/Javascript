package com.accenture.resource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement //---> <tx:annotation-driven/>
@EnableJpaRepositories(basePackages= "com.accenture.dao" ,transactionManagerRef="txManager")
@ComponentScan("com")
public class JavaConfig {
	
	
	 @Bean
	  public DataSource dataSource() {
		 BasicDataSource ds = new BasicDataSource();
		 ds.setDriverClassName("com.mysql.jdbc.Driver");
		 ds.setUrl("jdbc:mysql://localhost:3306/springbootdemos");
		 ds.setUsername("root");
		 ds.setPassword("root");
		 return ds;
	    
	  }

	  @Bean
	  public EntityManagerFactory entityManagerFactory(DataSource dataSource) { //ManagedDataSource

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);
	    vendorAdapter.setShowSql(true);
	    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.accenture.entity");
	    factory.setDataSource(dataSource);
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }
	  @Bean(name="txManager")
	  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {//managed Object EntityManagerFactory
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory);
	    return txManager;
	  }

}
