package fun.happyhacker;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamingDemo {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Person> flintstones = env.fromElements(
                new Person("Fred", 35, 100L),
                new Person("Wilma", 35, 300L),
                new Person("Pebbles", 2, 0L));

        DataStream<Person> adults = flintstones
                .filter(person -> person.getAge() >= 18)
                .setParallelism(3)
                .filter(person -> person.getSalary() > 100L)
                .setParallelism(3);


        adults.print();

        env.execute();
    }

    @Data
    @AllArgsConstructor
    public static class Person {
        public String name;
        public Integer age;
        public Long salary;
    }
}
