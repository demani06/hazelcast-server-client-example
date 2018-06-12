package com.deepak.hazelcastclient;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spi.discovery.integration.DiscoveryServiceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HazelcastClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastClientApplication.class, args);
	}
	/*@Bean
	public Ha hazelCastInstance(){
		ClientConfig clientConfig = new ClientConfig();
	*//*	//clientConfig.setGroupConfig(new GroupConfig().)

		SerializationConfig serializationConfig = clientConfig.getSerializationConfig();
		serializationConfig.addPortableFactoryClass(1, PortableFactoryImpl.class);*//*
		return Hazelcast.newJetClient(clientConfig);
	}*/

	@Bean
	public HazelcastInstance hazelcastInstance() {
		return HazelcastClient.newHazelcastClient(clientConfig());
	}

	@Bean
	public ClientConfig clientConfig() {
		ClientConfig clientConfig = new ClientConfig();

		SerializationConfig serializationConfig = new SerializationConfig();
		serializationConfig.addPortableFactory(3,new PortableFactoryImpl());
		clientConfig.setSerializationConfig(serializationConfig);
		return clientConfig;
	}
}


