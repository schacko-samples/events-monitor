package com.bisnode.monitoring.service.consumer.eventsconsumer.config;

import com.bisnode.monitoring.service.consumer.eventsconsumer.EventsStream;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author tess
 * @since 2020-02-12
 */
@TestConfiguration
@EnableBinding(EventsStream.class)
public class KafkaTestConfig {

//  @Bean @Primary
//  public SchemaRegistryClient schemaRegistryClient() {
//    return (SchemaRegistryClient) new MockSchemaRegistryClient();
//  }

}
