package com.java.app_security.repositories;

import com.java.app_security.entites.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, BigInteger> {

    Optional<CustomerEntity> findByEmail(String email);

}
