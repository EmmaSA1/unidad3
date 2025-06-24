package utez.edu.mx.unidad3.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConnection {

    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.username}")
    private String DB_USERNAME;

    @Value("${db.password}")
    private String DB_PASSWORD;

    @Bean
    public DataSource getConnection() {
        try {
            DriverManagerDataSource configuration = new DriverManagerDataSource();
            configuration.setUrl(DB_URL);
            configuration.setUsername(DB_USERNAME);
            configuration.setPassword(DB_PASSWORD);
            configuration.setDriverClassName("com.mysql.cj.jdbc.Driver");

              /*
            1- Como si fuera una pagina: con.mysql
            2.- GTA SA: cj
            3.- Protocolo de base de datos: jdbc
            4.- Calse: Drive
            */

            return configuration;

        } catch (Exception ex) {
            System.out.println("Error al conectar a la BD: " + ex.getMessage());
            return null;
        }
    }
}