package com.bisnode.monitoring.service.producer;

import com.bisnode.monitoring.events.schema.Event;

/**
 * @author tess
 * @since 2020-02-14
 */
public interface EventsService {
  void createEvent(Event event);
}
