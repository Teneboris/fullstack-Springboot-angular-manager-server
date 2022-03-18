package com.example.fullstackspringbootangularmanagerserver;

import com.example.fullstackspringbootangularmanagerserver.enumeration.Status;
import com.example.fullstackspringbootangularmanagerserver.model.Server;
import com.example.fullstackspringbootangularmanagerserver.repository.ServerRepository;
import com.example.fullstackspringbootangularmanagerserver.service.implementation.ServerServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.fullstackspringbootangularmanagerserver.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class FullstackSpringbootAngularManagerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullstackSpringbootAngularManagerServerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepository serverRepository) {
        return args -> {
            serverRepository.save(new Server(null, "192.168.1.160", "Unbuntu Linux", "16GB", "Personal PC", "http://localhost:8080/server/image/server1.png", SERVER_UP));
            serverRepository.save(new Server(null, "192.168.1.58", "IOS", "256GB", "Dell Tower", "http://localhost:8080/server/image/server2.png", SERVER_UP));
            serverRepository.save(new Server(null, "192.168.1.22", "Unbuntu Manjaro", "24GB", "Web Server", "http://localhost:8080/server/image/server3.png", SERVER_UP));
            serverRepository.save(new Server(null, "192.168.1.78", "Winsdows", "67GB", "Mail Server", "http://localhost:8080/server/image/server4.png", SERVER_UP));
        };
    }

}
