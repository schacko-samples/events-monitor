package com.bisnode.monitoring.service;

import com.bisnode.monitoring.events.schema.*;
import com.bisnode.monitoring.service.config.EventsBinding;
import com.bisnode.monitoring.service.config.KafkaTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(properties = "com.bisnode.monitoring.event.test.enabled=true")
@Import(KafkaTestConfig.class)
@DirtiesContext
@EmbeddedKafka(
  bootstrapServersProperty = "spring.kafka.bootstrap-servers",
  partitions = 10,
  topics = {
    "monitoring-eventsBinding"
  })
class EventsMonitoringApplicationTests {

  @Autowired
  private EventsBinding eventsBinding;

  private Event event;
  private EventKey eventKey;

  @BeforeEach
  void setUp() {
    Details details = Details.newBuilder()
      .setAmount(EventAmount.newBuilder().setCurrency("SEK").setValue(0.0D).build())
      .setType(EventType.newBuilder().setCategory("FINANCIAL_INFORMATION").setCode("NUMBER_OF_EMPLOY").build())
      .setChange(EventChange.newBuilder().setNewValue("").setOldValue("").build())
      .setSsn(Arrays.asList())
      .setRegistrationDate("2020-02-07T14:12:55.21")
      .setEventDate("2020-02-07T14:12:55.21")
      .setComment("")
      .build();

    Company company = Company.newBuilder()
      .setCompanyId("")
      .setName("Team One Security ApS")
      .setRating("AA")
      .setAddedDate("2020-02-07T14:12:55.21")
      .setChangedDateTime("2020-02-07T14:12:55.21")
      .setCountryRegistrationNumber("32358659")
      .setDuns("305106495")
      .setReference("ref")
      .setCountry("dk")
      .setInternalId("dk-32358659")
      .setPortfolioAction("change")
      .build();

    event = Event.newBuilder()
      .setEventId("2677762869a71f439b4b56a7324b0f51626853238645666704")
      .setPublishDate("2020-02-07T14:12:55.208")
      .setCompany(company)
      .setDetails(details)
      .setType("INCREMENTAL")
      .build();

    eventKey = EventKey.newBuilder()
      .setEventId(event.getEventId())
      .build();
  }

  @Test
  void handleEvents() {
    Message<Event> message = MessageBuilder
      .withPayload(event)
      .setHeader(KafkaHeaders.MESSAGE_KEY, event.getEventId())
      .build();

    assertNotNull(this.eventsBinding);
    eventsBinding.monitoringEventsOut().send(message);

  }

}
