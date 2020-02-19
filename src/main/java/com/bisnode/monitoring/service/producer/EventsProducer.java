package com.bisnode.monitoring.service.producer;

import com.bisnode.monitoring.events.schema.*;
import com.bisnode.monitoring.service.config.EventsBinding;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tess
 * @since 2020-02-13
 */
@Service
@Slf4j
public class EventsProducer {

  public static void main(String... args) {

    ObjectMapper mapper = new ObjectMapper();
    Serde<Event> eventSerde = new JsonSerde<>(Event.class, mapper);


    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ProducerConfig.RETRIES_CONFIG, 0);
    props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
    props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
    props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
    props.put("schema.registry.url", "http://localhost:8081");

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
      .setCompanyId("123456789")
      .setInternalId("123456789")
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

    Event event = Event.newBuilder()
      .setEventId("2677762869a71f439b4b56a7324b0f51626853238645666704")
      .setPublishDate("2020-02-07T14:12:55.208")
      .setCompany(company)
      .setDetails(details)
      .setType("INCREMENTAL")
      .build();

    EventKey eventKey = EventKey.newBuilder()
      .setEventId(event.getEventId())
      .build();

    DefaultKafkaProducerFactory<EventKey, Event> pf = new DefaultKafkaProducerFactory<>(props);
    KafkaTemplate<EventKey, Event> template = new KafkaTemplate<>(pf, true);
    template.setDefaultTopic(EventsBinding.INPUT);

    template.sendDefault(eventKey, event);
  }
}
