package com.bisnode.monitoring.service.controller;

import com.bisnode.monitoring.events.schema.Event;
import com.bisnode.monitoring.service.producer.EventsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author tess
 * @since 2020-02-14
 */
@RestController
@RequestMapping(value = "/events")
@Slf4j
public class EventsController {

  private EventsService eventsService;

  public EventsController(@Autowired EventsService eventsService) {
    this.eventsService = eventsService;
  }

  @PostMapping(consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody String eventJson) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    try {
      Event event = mapper.readValue(eventJson, Event.class);
      eventsService.createEvent(event);
    } catch (Throwable e) {
      log.error(e.getMessage());
      throw e;
    }
  }
}
