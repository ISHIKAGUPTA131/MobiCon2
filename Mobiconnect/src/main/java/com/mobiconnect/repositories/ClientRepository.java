package com.mobiconnect.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mobiconnect.entities.Client;

public interface ClientRepository extends CrudRepository<Client,Integer>{
    public Client findById(int id);

    public void save(int clientId);

}

    