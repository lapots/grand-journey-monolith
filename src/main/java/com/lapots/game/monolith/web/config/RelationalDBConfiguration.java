package com.lapots.game.monolith.web.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.lapots.game.monolith.repository.relational")
@EntityScan("com.lapots.game.monolith.domain")
public class RelationalDBConfiguration {
}
