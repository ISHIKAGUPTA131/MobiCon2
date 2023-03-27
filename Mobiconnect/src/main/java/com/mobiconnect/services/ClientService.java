package com.mobiconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobiconnect.entities.Client;
import com.mobiconnect.repositories.ClientRepository;

@Component
public class ClientService {
    
    @Autowired
    private ClientRepository clientTableRepository;

    // search clients by name
    public List<Client> searchClientsByName(String name) {
        return clientTableRepository.findByNameContaining(name);
    }


    //get all clients
    public List<Client> getAllClient()
    {
        List<Client>list=(List<Client>)this.clientTableRepository.findAll();
        return list;
    }

     //get  client by id
    public Client getClientById(int id)
    {
        Client clientTable=null;
        try{
        clientTable=this.clientTableRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return clientTable;
    }


     //adding the client
     public Client addClient(Client c)
     {

         Client result=clientTableRepository.save(c);
         return result;
     }



     //delete client
    public void deleteClient(int cid) {
        clientTableRepository.deleteById(cid);

    }



    //update client
    public void updateClient(Client clientTable, int clientId)
    {
        clientTable.setId(clientId);
        clientTableRepository.save(clientTable);
    }

   
}
