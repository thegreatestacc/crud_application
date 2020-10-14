package com.sovliv.crud_rest_oracle_app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sovliv.crud_rest_oracle_app.model.Client;
import com.sovliv.crud_rest_oracle_app.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CrudRestOracleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudRestOracleApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ClientService clientService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            //mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            //mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            TypeReference<List<Client>> reference = new TypeReference<>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/clients.json");
            try {
                List<Client> clients = mapper.readValue(inputStream, reference);
                clientService.saveAll(clients);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

}
