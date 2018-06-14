package com.deepak.hazelcastserver;

import com.deepak.hazelcastserver.domain.Person;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.deepak"})
@EnableJpaRepositories("com.deepak.hazelcastserver.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "com.deepak.hazelcastserver.domain")

//@EnableHazelcastRepositories("com.deepak.hazelcastserver.repository")
public class HazelcastServerApplication {

	public static void main(String[] args) {
		//addObjectsToHazelCastMap();
		SpringApplication.run(HazelcastServerApplication.class, args);
	}
}
