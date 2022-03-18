package com.example.fullstackspringbootangularmanagerserver.model;

import com.example.fullstackspringbootangularmanagerserver.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    /**
     * we can´t get more than one ip address
     */
    @Column(unique = true)
    @NotEmpty(message="IP Address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String menory;
    private String type;
    private String imageUrl;
    private Status status;
}
