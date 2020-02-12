package com.bisnode.monitoring.service.consumer.eventsconsumer;

import com.bisnode.monitoring.events.schema.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

/**
 * @author tess
 * @since 2020-02-07
 */
@Service
@Slf4j
public class EventsConsumer {

  @StreamListener(Processor.INPUT)
  public void handleEvents(Event event) {
    log.info("Received event: {}", event);
  }
}
