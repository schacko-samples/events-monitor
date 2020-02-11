package com.bisnode.monitoring.service.consumer.eventsconsumer.config;

import com.bisnode.monitoring.service.consumer.eventsconsumer.EventsStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

/**
 * @author tess
 * @since 2020-02-07
 */
@EnableKafkaStreams
@Configuration
public class KafkaConfig {

  @EnableBinding(EventsStream.class)
  public class StreamsConfig {
  }

//  @Bean
//  public NewTopic monitoringEvents() {
//    return TopicBuilder.name("monitoringEventsTopic").build();
//  }
}
