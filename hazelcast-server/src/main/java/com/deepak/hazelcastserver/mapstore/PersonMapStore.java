package com.deepak.hazelcastserver.mapstore;

import com.deepak.hazelcastserver.config.BeanUtil;
import com.deepak.hazelcastserver.domain.Person;
import com.deepak.hazelcastserver.domain.PersonWrapper;
import com.deepak.hazelcastserver.repository.PersonWrapperRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.MapStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PersonMapStore implements MapStore<Long, Person> {

    @Autowired
    PersonWrapperRepository personWrapperRepository;

    @Override
    public void store(Long aLong, Person person) {
        System.out.println("*************STORE METHOD**********************************");
        Random rand = new Random();
        person.setId(rand.nextInt(9));
        System.out.println(person.getId());
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = null;
        try {
            jsonResponse = objectMapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("jsonResponse=="+jsonResponse);
        System.out.println("rand.nextInt()=="+rand.nextInt());

        PersonWrapperRepository personWrapperRepository = BeanUtil.getBean(PersonWrapperRepository.class);

        System.out.println("personWrapperRepository=="+personWrapperRepository);
        PersonWrapper personWrapper = new PersonWrapper(rand.nextInt(1000), jsonResponse);

        personWrapperRepository.save(personWrapper);
    }

    @Override
    public void storeAll(Map<Long, Person> map) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void deleteAll(Collection<Long> collection) {

    }

    @Override
    public Person load(Long aLong) {
        return null;
    }

    @Override
    public Map<Long, Person> loadAll(Collection<Long> collection) {
        System.out.println("*************loadAll METHOD**********************************");
        return null;
    }

    @Override
    public Iterable<Long> loadAllKeys() {
        System.out.println("*************loadAllKeys METHOD**********************************");
        return null;
    }
}
