package br.com.hmb_client.service;

import br.com.hmb_client.dto.AddressDto;
import br.com.hmb_client.model.AddressModel;
import br.com.hmb_client.repository.AddressRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CityService cityService;

    @Transactional
    public AddressModel save(AddressDto addressDto){
        AddressModel address = new AddressModel();
        BeanUtils.copyProperties(addressDto, address);
        address.setCity(cityService.findById(addressDto.getCity()).get());
        return addressRepository.save(address);
    }

    public Optional<AddressModel> findById(Long id){
        return addressRepository.findById(id);
    }

    public void delete(Long id) throws Exception{
        Optional<AddressModel> address = findById(id);
        if(address.get().getId() != null){
            addressRepository.delete(address.get());
        }else{
            throw new Exception("Endereço não existe!");
        }
    }
}
