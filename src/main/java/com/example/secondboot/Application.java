package com.example.secondboot;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void setDataSource(DataSource ds) {
        this.dataSource=ds;
        /*dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        dataSource.setUrl("jdbc:derby:c:\\temp\\database\\test01;create=true");
        dataSource.setUsername("");
        dataSource.setPassword("");
        // Inject the datasource into the dao
        dao.setDataSource(dataSource);*/
    }

    @Override
    public void run(String... args) throws Exception {
       String sql = "INSERT INTO member (firstName, lastName, city) VALUES ("
                + "'Nicole', 'Hafner', 'Bochum')";

       // int rows = jdbcTemplate.update(sql);
        /*if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }*/
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot");
            String [] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
