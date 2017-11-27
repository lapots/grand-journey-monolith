package com.lapots.game.monolith.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.lapots.game.monolith.repository.graph")
public class GraphDBConfiguration {
}
