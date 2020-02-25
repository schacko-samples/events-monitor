package com.bisnode.monitoring.service.consumer;

import java.util.function.Consumer;

import com.bisnode.monitoring.events.schema.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author tess
 * @since 2020-02-07
 */
@Service
@Slf4j
public class EventsConsumer {

  @Bean
  public Consumer<Event> handleEvent() {
    return event -> {
      log.info("Received event: {}", event);
    };
  }

}
