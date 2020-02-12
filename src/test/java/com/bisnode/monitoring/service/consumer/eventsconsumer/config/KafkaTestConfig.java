package com.bisnode.monitoring.service.consumer.eventsconsumer.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;

/**
 * @author tess
 * @since 2020-02-12
 */
@TestConfiguration
@EnableSchemaRegistryClient
@EnableBinding(Processor.class)
public class KafkaTestConfig {

}
