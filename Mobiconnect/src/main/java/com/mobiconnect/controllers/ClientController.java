package com.mobiconnect.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobiconnect.entities.Client;
import com.mobiconnect.services.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientTableService;

    // search clients by name
    @GetMapping("/client/search")
    public ResponseEntity<List<Client>> searchClientsByName(@RequestParam String name) {
        List<Client> clients = clientTableService.searchClientsByName(name);
        if (clients.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(clients);
    }



    //get all clients
    @GetMapping("/client")
    public ResponseEntity<List<Client>> getClient()
    {
        List<Client>list=clientTableService.getAllClient();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       
        return ResponseEntity.of(Optional.of(list));

    }


    //get client by id
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id")int id)
    {
        Client clientTable=clientTableService.getClientById(id);
        if(clientTable==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(clientTable));
    }



    //post data
    @PostMapping("/client")
    public ResponseEntity<Optional<Client>> addClient(@RequestBody Client clientTable)
    {
        Client c=null;
       try{
            c=this.clientTableService.addClient(clientTable);
            System.out.println(clientTable);
            return ResponseEntity.ok(Optional.of(c));
       }
       catch(Exception e)
       {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }


    //delete client
    @DeleteMapping("/client/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable("clientId")int clientId)
    {
       try{
        this.clientTableService.deleteClient(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

       }
    }



    @PutMapping("/client/{clientId}")
    public ResponseEntity<Client>updateClient(@RequestBody Client clientTable, @PathVariable("clientId")int clientId)
    {
        try{
            this.clientTableService.updateClient(clientTable,clientId);
            return ResponseEntity.ok().body(clientTable);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
