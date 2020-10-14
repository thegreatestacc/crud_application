package com.sovliv.crud_rest_oracle_app.repository;

import com.sovliv.crud_rest_oracle_app.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
