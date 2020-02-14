package com.bisnode.monitoring.service.config;

import com.bisnode.monitoring.service.EventsStream;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;

/**
 * @author tess
 * @since 2020-02-12
 */
@TestConfiguration
@EnableSchemaRegistryClient
@EnableBinding(EventsStream.class)
public class KafkaTestConfig {

}
