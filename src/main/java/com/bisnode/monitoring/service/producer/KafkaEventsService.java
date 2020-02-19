package com.bisnode.monitoring.service.producer;

import com.bisnode.monitoring.events.schema.Event;
import com.bisnode.monitoring.events.schema.EventKey;
import com.bisnode.monitoring.service.config.EventsBinding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author tess
 * @since 2020-02-13
 */
@Service
@Slf4j
public class KafkaEventsService implements EventsService {

  private EventsBinding eventsBinding;

  public KafkaEventsService(EventsBinding eventsBinding) {
    this.eventsBinding = eventsBinding;
  }

  @Override
  public Event createEvent(Event event) {
    log.info("sending event {} to topic: {}", event.getEventId(), eventsBinding.INPUT);
    try {
      EventKey eventKey = EventKey.newBuilder().setEventId(event.getEventId()).build();
      Message<Event> message = MessageBuilder
        .withPayload(event)
        .setHeader(KafkaHeaders.MESSAGE_KEY, eventKey)
        .build();
      eventsBinding.monitoringEventsIn().send(message);
    } catch (Throwable e) {
      log.error("Error sending event: {}", e.getMessage());
    }
    return event;
  }
}
