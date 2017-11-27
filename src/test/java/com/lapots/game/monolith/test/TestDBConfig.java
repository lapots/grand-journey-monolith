package com.lapots.game.monolith.test;

import de.flapdoodle.embed.process.runtime.Network;
import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import ru.yandex.qatools.embed.postgresql.PostgresExecutable;
import ru.yandex.qatools.embed.postgresql.PostgresProcess;
import ru.yandex.qatools.embed.postgresql.PostgresStarter;
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig;
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class TestDBConfig {
    final PostgresConfig config = new PostgresConfig(
            Version.V9_6_5,
            new AbstractPostgresConfig.Net("localhost", Network.getFreeServerPort()),
            new AbstractPostgresConfig.Storage("test"),
            new AbstractPostgresConfig.Timeout(),
            new AbstractPostgresConfig.Credentials("user", "pass")
    );

    public TestDBConfig() throws IOException {
    }

    @Bean(destroyMethod = "stop", name = "postgresProcess")
    PostgresProcess postgresProcess() throws IOException {
        PostgresStarter<PostgresExecutable, PostgresProcess> runtime = PostgresStarter.getDefaultInstance();
        PostgresExecutable exec = runtime.prepare(config);
        PostgresProcess process = exec.start();
        return process;
    }

    @Bean(destroyMethod = "close")
    @DependsOn("postgresProcess")
    DataSource dataSource() {
        PGPoolingDataSource ds = new PGPoolingDataSource();
        ds.setUser(config.credentials().username());
        ds.setPassword(config.credentials().password());
        ds.setPortNumber(config.net().port());
        ds.setServerName(config.net().host());
        ds.setDatabaseName(config.storage().dbName());
        return ds;
    }
}
