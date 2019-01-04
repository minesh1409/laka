package com.lakazambia.api.connection;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class RethinkDBConfiguration {
    // connect to docker
	
//    public static final String DBHOST = "db.simha.online";
	
	@Value("${rethink.host}")
    public String DBHOST;//=null;
	
    @Bean
    public RethinkDBConnectionFactory connectionFactory() {
    	System.out.println("DBHOST :: " +DBHOST);
        return new RethinkDBConnectionFactory(DBHOST);
    }

    @Bean
    DbInitializer dbInitializer() {
        return new DbInitializer();
    }
}
