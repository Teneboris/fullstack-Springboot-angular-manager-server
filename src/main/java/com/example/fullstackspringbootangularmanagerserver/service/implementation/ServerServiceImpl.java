package com.example.fullstackspringbootangularmanagerserver.service.implementation;

import com.example.fullstackspringbootangularmanagerserver.model.Server;
import com.example.fullstackspringbootangularmanagerserver.repository.ServerRepository;
import com.example.fullstackspringbootangularmanagerserver.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Random;

import static com.example.fullstackspringbootangularmanagerserver.enumeration.Status.SERVER_DOWN;
import static com.example.fullstackspringbootangularmanagerserver.enumeration.Status.SERVER_UP;
import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {

    private final ServerRepository serverRepository;

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        //server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }

    /**
     * will go to the Database and selected the Server by IP Address
     * when the Server ist reachable on 1s it will set the status to up
     * otherwise set the status to down
     * @param ipAddress
     * @return
     */
    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000)? SERVER_UP:SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fechting all servers");
        return serverRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server getID(Long id) {
        log.info("Fechting server by id: {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server: {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting by id: {}", id);
        serverRepository.deleteById(id);
        return TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = {"Server1", "Server2", "Server3", "Server4"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("server/image"+ imageNames[new Random().nextInt(4)]).toUriString();
    }

}
