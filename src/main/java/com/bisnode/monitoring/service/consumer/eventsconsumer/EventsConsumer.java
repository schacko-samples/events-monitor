package com.bisnode.monitoring.service.consumer.eventsconsumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

/**
 * @author tess
 * @since 2020-02-07
 */

public class EventsConsumer {

  @Bean
  public Consumer<KStream<String, String>> process() {
    return null;
  }
}
