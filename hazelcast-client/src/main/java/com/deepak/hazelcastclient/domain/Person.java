package com.deepak.hazelcastclient.domain;

import com.deepak.hazelcastclient.PortableFactoryImpl;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements Serializable,Portable {

    private long id;
    private String firstName;
    private String lastName;

    @Override
    public int getFactoryId() {
        return PortableFactoryImpl.FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return PortableFactoryImpl.CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF("firstName", firstName);
        portableWriter.writeUTF("lastName", lastName);
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        this.firstName=portableReader.readUTF("firstName");
        this.lastName=portableReader.readUTF("lastName");
    }
}
