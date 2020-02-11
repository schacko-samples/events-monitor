package com.bisnode.monitoring.service.consumer.eventsconsumer;

import com.bisnode.common.monitoring.model.event.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author tess
 * @since 2020-02-07
 */
@Component
@Slf4j
public class EventsConsumer {

  @StreamListener(EventsStream.INPUT)
  public void handleEvents(@Payload Event event) {
    log.info("Received event: {}", event);
  }
}
