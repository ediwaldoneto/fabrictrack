package br.com.nt.fabrictrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
	DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
	MongoAutoConfiguration.class })
@ComponentScan(basePackages = { "br.com.nt.fabrictrack.*" })
public class FabrictrackApplication {

    public static void main(String[] args) {
	SpringApplication.run(FabrictrackApplication.class, args);
    }

}
