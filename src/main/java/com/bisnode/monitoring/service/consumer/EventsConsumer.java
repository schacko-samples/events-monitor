package com.bisnode.monitoring.service.consumer;

import com.bisnode.monitoring.events.schema.Event;
import com.bisnode.monitoring.service.config.EventsBinding;
import com.bisnode.monitoring.service.producer.EventsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

/**
 * @author tess
 * @since 2020-02-07
 */
@Service
@Slf4j
public class EventsConsumer {

  private EventsService eventsService;

  public EventsConsumer(EventsService eventsService) {
    this.eventsService = eventsService;
  }

  @StreamListener(target = EventsBinding.INPUT)
  @SendTo(EventsBinding.OUTPUT)
  public String handleEvents(Event event) {
    log.info("Received event: {}", event);
    return "{'name': 'test}";
  }
}
