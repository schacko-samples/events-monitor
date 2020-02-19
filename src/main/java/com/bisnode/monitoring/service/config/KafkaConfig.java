package com.bisnode.monitoring.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

/**
 * @author tess
 * @since 2020-02-07
 */
@Configuration
@EnableKafkaStreams
@EnableBinding(EventsBinding.class)
@ConditionalOnProperty(
  name = "com.bisnode.monitoring.event.test.enabled",
  havingValue = "false",
  matchIfMissing = true)
public class KafkaConfig {

  @Value("${spring.cloud.stream.schemaRegistryClient.endpoint}")
  private String endPoint;

  @Bean
  public SchemaRegistryClient schemaRegistryClient() {
    ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
    client.setEndpoint(endPoint);
    return client;
  }

//  @Bean
//  public NewTopic monitoringEvents() {
//    return TopicBuilder.name("monitoringEventsTopic").build();
//  }
}
