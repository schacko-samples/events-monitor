package com.bisnode.monitoring.service.consumer;

import com.bisnode.monitoring.events.schema.Event;
import com.bisnode.monitoring.service.EventsStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @author tess
 * @since 2020-02-07
 */
@Service
@Slf4j
public class EventsConsumer {

  @StreamListener(EventsStream.INPUT)
  public void handleEvents(Event event) {

    log.info("Received event: {}", event);
  }
}
