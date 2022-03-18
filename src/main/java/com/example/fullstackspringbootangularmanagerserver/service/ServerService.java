package com.example.fullstackspringbootangularmanagerserver.service;

import com.example.fullstackspringbootangularmanagerserver.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {
    Server create(Server server);

    /**
     * it will return the Server that we try to ping
     * @param ipAddress
     * @return
     */
    Server ping(String ipAddress) throws IOException;

    /**
     * limit the number of Server they are returning
     * @param limit
     * @return
     */
    Collection<Server> list(int limit);
    Server getID(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
