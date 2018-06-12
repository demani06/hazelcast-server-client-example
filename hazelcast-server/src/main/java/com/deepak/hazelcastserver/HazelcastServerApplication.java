package com.deepak.hazelcastserver;

import com.deepak.hazelcastserver.domain.Person;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;

@SpringBootApplication(excludeName = {"org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration"})
@EnableHazelcastRepositories("com.deepak.hazelcastserver.repository")
public class HazelcastServerApplication {

	public static void main(String[] args) {
		//addObjectsToHazelCastMap();
		SpringApplication.run(HazelcastServerApplication.class, args);
	}
}
