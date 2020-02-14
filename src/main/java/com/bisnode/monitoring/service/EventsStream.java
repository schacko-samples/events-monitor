package com.bisnode.monitoring.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author tess
 * @since 2020-02-14
 */
public interface EventsStream {
  String INPUT = "monitoring-events-in";
  String OUTPUT = "monitoring-events-out";

  @Input(INPUT)
  SubscribableChannel monitoringEventsIn();

  @Output(OUTPUT)
  MessageChannel monitoringEventsOut();
}
