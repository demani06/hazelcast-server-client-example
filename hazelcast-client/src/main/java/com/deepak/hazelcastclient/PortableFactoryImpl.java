package com.deepak.hazelcastclient;

import com.deepak.hazelcastclient.domain.Person;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;

public class PortableFactoryImpl implements PortableFactory {


    public static final int CLASS_ID = 3;
    public static final int FACTORY_ID = 3;

    @Override
    public Portable create(int classId) {
        switch (classId){
            case CLASS_ID:
                return new Person();
                default:
                    return null;
        }
    }
}
