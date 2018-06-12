package com.deepak.hazelcastserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.keyvalue.annotation.KeySpace;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@KeySpace
public class PersonWrapper implements Serializable{

    @Id
    private long personWrapperId;

    @Lob
    private String personJson;

}
