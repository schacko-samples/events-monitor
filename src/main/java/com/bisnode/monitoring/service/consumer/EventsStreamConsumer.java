package com.bisnode.monitoring.service.consumer;

import com.bisnode.monitoring.events.schema.Event;
import com.bisnode.monitoring.events.schema.EventKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @author tess
 * @since 2020-02-07
 */
@Configuration
@Slf4j
public class EventsStreamConsumer {

  @Bean
  public Consumer<KStream<EventKey, Event>> processEvent() {
    return input -> input.foreach((eventKey, event) -> {
      log.info("Received stream event: {}", event);
    });
  }
}
