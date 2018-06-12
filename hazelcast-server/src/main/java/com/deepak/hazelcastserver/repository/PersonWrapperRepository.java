package com.deepak.hazelcastserver.repository;

import com.deepak.hazelcastserver.domain.PersonWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonWrapperRepository extends KeyValueRepository<PersonWrapper,Long>,JpaRepository<PersonWrapper,Long> {
}
