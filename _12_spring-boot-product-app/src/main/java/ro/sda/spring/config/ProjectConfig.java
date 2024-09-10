package ro.sda.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class ProjectConfig {
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPass;

    public ProjectConfig() {
        log.info("ProjectConfig constructor called!");
    }

    @Bean
    public DataSource dataSource() {
        log.info("Database driver {}", driverClassName);
        log.info("Database url {}", datasourceUrl);
        log.info("Database user {}", dbUser);
        // this is not a good practice to log the password, but we are doing it for learning purposes
        log.info("Database pass {}", dbPass);

        var ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(datasourceUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPass);

        return ds;
    }

    @Bean
    public JdbcTemplate primaryJdbc() {
        log.info("DATASOURCE 1 " + dataSource());
        var templ = new JdbcTemplate(dataSource());
        log.info("primaryJdbc " + templ);
        return templ;
    }

}
