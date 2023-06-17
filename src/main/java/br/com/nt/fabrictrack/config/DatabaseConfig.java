/**
 * 
 */
package br.com.nt.fabrictrack.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Neto
 *
 */
@Configuration
public class DatabaseConfig {

    @Value("${datasource.driver_class_name}")
    private String driverName;
    @Value("${datasource.pool_name}")
    private String poolName;
    @Value("${datasource.url}")
    private String url;
    @Value("${datasource_username}")
    private String userName;
    @Value("${datasource_password}")
    private String userPass;
    @Value("${datasource.connection_timeout}")
    private Long connectionTimeOut;
    @Value("${datasource.max_pool_size}")
    private int maxPoolSize;
    
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(userPass);
        return dataSource;
    }

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
