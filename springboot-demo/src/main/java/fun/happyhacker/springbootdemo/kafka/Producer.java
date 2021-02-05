package fun.happyhacker.springbootdemo.kafka;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.ByteArraySerializer;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Log4j2
public class Producer {
    private static final String BOOTSTRAP_SERVERS = "10.73.33.38:6667,10.73.33.44:6667,10.75.12.85:6667";
    private static final String TOPIC = "kafka-test";

    public static void main(String[] args) {
        ProducerRecord<byte[], byte[]> record = new ProducerRecord<>(TOPIC, "and this is value".getBytes(StandardCharsets.UTF_8));
        KafkaProducer<byte[], byte[]> producer = getProducer();
        KafkaConsumer<byte[], byte[]> consumer = getConsumer();

        new Thread(() -> {
            int i = 0;
            while (i++ < 1000) {
                try {
                    Future<RecordMetadata> response = producer.send(record);
                    RecordMetadata metadata = response.get();
                    log.info("metadata {} {}", metadata.offset(), metadata.timestamp());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        ConsumerRecords<byte[], byte[]> records = consumer.poll(Duration.ofMillis(10));
        for (ConsumerRecord<byte[], byte[]> aRecord : records.records(TOPIC)) {
            if (aRecord != null && aRecord.key().length > 0 && aRecord.value().length > 0) {
                log.info("key {}, value {}", new String(aRecord.key(), StandardCharsets.UTF_8), new String(aRecord.value(), StandardCharsets.UTF_8));
            }
        }
    }

    private static KafkaProducer<byte[], byte[]> getProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "1");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName());

        return new KafkaProducer<>(properties);
    }

    private static KafkaConsumer<byte[], byte[]> getConsumer() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "mygroup");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class.getName());
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1000);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 50);

        KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singletonList(TOPIC));

        return consumer;
    }
}
