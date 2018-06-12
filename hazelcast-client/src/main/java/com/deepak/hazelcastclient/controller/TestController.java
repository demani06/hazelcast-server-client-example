package com.deepak.hazelcastclient.controller;

import com.deepak.hazelcastclient.domain.Person;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TestController {

    @Autowired
    private HazelcastInstance instance;

    @GetMapping("/person")
    public void getPersonsFromMap(){
        System.out.println("getPersonsFromMap^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+instance);

        IMap<Long, Person> personMap= instance.getMap("personMap");

        personMap.put(2L, new Person(2L,"Robert","Downey"));
        personMap.put(3L, new Person(3L,"Roberto","Carlos"));
        personMap.put(5L, new Person(5L,"Paul","Pogba"));

        System.out.println(personMap.values());

    }

}
