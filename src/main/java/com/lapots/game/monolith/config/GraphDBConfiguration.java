package com.lapots.game.monolith.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.lapots.game.monolith.repository.graph")
@EntityScan("com.lapots.game.monolith.domain")
public class GraphDBConfiguration {
}
