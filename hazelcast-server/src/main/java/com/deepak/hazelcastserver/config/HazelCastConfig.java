package com.deepak.hazelcastserver.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hazelcast.HazelcastKeyValueAdapter;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.core.KeyValueTemplate;

@Configuration
//@EnableHazelcastRepositories(basePackages={"com.deepak.hazelcastmapstoreexample.respository"})
@ComponentScan
public class HazelCastConfig {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();

        MapConfig mapConfig = config.getMapConfig("personMap");
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setEnabled(true);
        mapStoreConfig.setClassName("com.deepak.hazelcastserver.mapstore.PersonMapStore");
        mapStoreConfig.setWriteDelaySeconds(0);
        mapConfig.setMapStoreConfig(mapStoreConfig);


        SerializationConfig serializationConfig = new SerializationConfig();
        serializationConfig.addPortableFactory(3,new PortableFactoryImpl());
        config.setSerializationConfig(serializationConfig);

        return Hazelcast.newHazelcastInstance(config);
    }


    @Bean
    public KeyValueOperations keyValueTemplate(){
        return new KeyValueTemplate(new HazelcastKeyValueAdapter(hazelcastInstance()));
    }

    @Bean
    public HazelcastKeyValueAdapter hazelcastKeyValueAdapter(HazelcastInstance instance){
        return new HazelcastKeyValueAdapter(instance);
    }
}
