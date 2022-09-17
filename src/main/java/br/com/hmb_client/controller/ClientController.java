package br.com.hmb_client.controller;

import br.com.hmb_client.dto.ClientDto;
import br.com.hmb_client.model.ClientModel;
import br.com.hmb_client.service.AddressService;
import br.com.hmb_client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    AddressService addressService;


    @PostMapping("")
    public ResponseEntity createClient(@RequestBody ClientDto clientDto){

        ClientModel client = clientService.save(clientDto);

        return new ResponseEntity(client, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return new ResponseEntity(clientService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity findAll(){
        return new ResponseEntity(clientService.findAll(),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws Exception {
        clientService.delete(id);
        return new ResponseEntity("Cliente " + id + " excluido com sucesso", HttpStatus.OK);
    }
}
