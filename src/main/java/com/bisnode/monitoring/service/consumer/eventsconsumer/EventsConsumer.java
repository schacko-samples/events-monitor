package com.bisnode.monitoring.service.consumer.eventsconsumer;

import com.bisnode.monitoring.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author tess
 * @since 2020-02-07
 */
@Component
@EnableBinding(EventsStream.class)
@Slf4j
public class EventsConsumer {

  @StreamListener(EventsStream.INPUT)
  public void handleEvents(Event event) {
    log.info("Received event: {}", event);
  }
}
