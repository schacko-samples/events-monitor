package com.bisnode.monitoring.service.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author tess
 * @since 2020-02-14
 */
public interface EventsBinding {

  //  String STREAM_INPUT = "monitoring_events_stream";
  String INPUT = "monitoring_events_in";
  String OUTPUT = "monitoring_events_out";

//  @Input(STREAM_INPUT)
//  KStream<EventKey, Event> monitoringEventsStream();

  // Input topic
  @Input(INPUT)
  SubscribableChannel monitoringEventsIn();

  // Output topic
  @Output(OUTPUT)
  MessageChannel monitoringEventsOut();
}
