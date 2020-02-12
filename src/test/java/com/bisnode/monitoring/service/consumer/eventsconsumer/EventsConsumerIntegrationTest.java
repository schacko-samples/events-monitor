package com.bisnode.monitoring.service.consumer.eventsconsumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tess
 * @since 2020-02-11
 */
@RunWith(SpringRunner.class)
@DirtiesContext
@EmbeddedKafka(
  bootstrapServersProperty = "spring.kafka.bootstrap-servers",
  partitions = 10,
  topics = {"monitoring-events"})
class EventsConsumerIntegrationTest {

  @Autowired
  private KafkaTemplate<String, String> template;

  @BeforeEach
  void setUp() {
  }

  @Test
  void handleEvents() {
  }
}
