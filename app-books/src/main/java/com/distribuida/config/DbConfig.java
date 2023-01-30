package com.distribuida.config;


import com.zaxxer.hikari.HikariDataSource;
import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;


@ApplicationScoped
public class DbConfig {

    @Produces
    @ApplicationScoped
    public DataSource dataSource() {
        Config config = Config.create();
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl(config.get("db.connection.url").asString().get());
        ds.setUsername(config.get("db.connection.username").asString().get());
        ds.setPassword(config.get("db.connection.password").asString().get());
        return ds;
    }

    @Produces
    @ApplicationScoped
    public DbClient dbClient(){
        Config config=Config.create();
        return DbClient.builder()
                .config(config.get("db"))
                .build();
    }


}
