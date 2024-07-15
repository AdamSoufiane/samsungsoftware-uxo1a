package ai.shreds.infrastructure; 
  
 import org.springframework.context.annotation.Bean; 
 import org.springframework.context.annotation.Configuration; 
 import org.springframework.orm.jpa.JpaTransactionManager; 
 import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; 
 import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; 
 import org.springframework.transaction.PlatformTransactionManager; 
 import javax.sql.DataSource; 
 import org.springframework.boot.jdbc.DataSourceBuilder; 
 import org.springframework.beans.factory.annotation.Value; 
 import org.springframework.orm.jpa.JpaVendorAdapter; 
 import java.util.Properties; 
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories; 
 import javax.persistence.EntityManagerFactory; 
  
 @Configuration 
 @EnableJpaRepositories(basePackages = {"ai.shreds.domain.repository"}) 
 public class InfrastructureDatabaseConfig { 
  
     @Value("${spring.datasource.url}") 
     private String dbUrl; 
  
     @Value("${spring.datasource.username}") 
     private String dbUsername; 
  
     @Value("${spring.datasource.password}") 
     private String dbPassword; 
  
     @Value("${spring.datasource.driver-class-name}") 
     private String dbDriverClassName; 
  
     @Bean 
     public DataSource dataSource() { 
         return DataSourceBuilder.create() 
                 .url(dbUrl) 
                 .username(dbUsername) 
                 .password(dbPassword) 
                 .driverClassName(dbDriverClassName) 
                 .build(); 
     } 
  
     @Bean 
     public LocalContainerEntityManagerFactoryBean entityManagerFactory() { 
         LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean(); 
         em.setDataSource(dataSource()); 
         em.setPackagesToScan("ai.shreds.domain"); 
  
         JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); 
         em.setJpaVendorAdapter(vendorAdapter); 
         em.setJpaProperties(hibernateProperties()); 
  
         return em; 
     } 
  
     @Bean 
     public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { 
         JpaTransactionManager transactionManager = new JpaTransactionManager(); 
         transactionManager.setEntityManagerFactory(emf); 
         return transactionManager; 
     } 
  
     private Properties hibernateProperties() { 
         Properties properties = new Properties(); 
         properties.setProperty("hibernate.hbm2ddl.auto", "update"); 
         properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect"); 
         properties.setProperty("hibernate.show_sql", "true"); 
         return properties; 
     } 
 }