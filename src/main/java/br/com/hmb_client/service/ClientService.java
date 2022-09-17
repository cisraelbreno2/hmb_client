package br.com.hmb_client.service;

import br.com.hmb_client.dto.ClientDto;
import br.com.hmb_client.model.AddressModel;
import br.com.hmb_client.model.ClientModel;
import br.com.hmb_client.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AddressService addressService;

    @Transactional
    public ClientModel save(ClientDto clientDto){
        ClientModel client = new ClientModel();
        BeanUtils.copyProperties(clientDto, client);
        client.setAddress(addressService.save(clientDto.getAddress()));
        return clientRepository.save(client);
    }

    public Optional<ClientModel> findById(Long id){
        return clientRepository.findById(id);
    }

    public List<ClientModel> findAll(){
        return clientRepository.findAll();
    }

    public void delete(Long id) throws Exception{
        Optional<ClientModel> client = findById(id);
        if(client.get().getId() != null){
            clientRepository.delete(client.get());
        }else{
            throw new Exception("Cliente não existe!");
        }
    }
}
