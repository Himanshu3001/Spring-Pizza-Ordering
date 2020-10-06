package com.himanshu.ecom.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.himanshu.ecom.entity.Item;
import com.himanshu.ecom.entity.OrderHistory;
import com.himanshu.ecom.entity.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.himanshu.ecom")
public class AppConfig implements WebMvcConfigurer {

	
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/hotel");
	    dataSource.setUsername("root");
	    dataSource.setPassword("root");
	    dataSource.setInitialSize(5);
	    dataSource.setMaxTotal(30);
	 
	    return dataSource;
	}
	
	
	
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	 
	    sessionBuilder.addAnnotatedClasses(User.class,Item.class,OrderHistory.class); 
	 
	    return sessionBuilder.buildSessionFactory();
	}
	
	
	
	  
	    @Autowired
	    @Bean
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }
	
	
	
}
