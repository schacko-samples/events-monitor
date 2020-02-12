package com.bisnode.monitoring.service.consumer.eventsconsumer.config;

import com.bisnode.monitoring.service.consumer.eventsconsumer.EventsStream;
import org.springframework.beans.factory.annotation.Value;
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
@EnableBinding(EventsStream.class)
public class KafkaConfig {

  @Value("${spring.cloud.stream.kafka.binder.producer-properties.schema.registry.url}")
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
