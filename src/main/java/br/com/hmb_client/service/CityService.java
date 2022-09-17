package br.com.hmb_client.service;

import br.com.hmb_client.model.CityModel;
import br.com.hmb_client.model.StateModel;
import br.com.hmb_client.repository.CityRepository;
import br.com.hmb_client.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public CityModel save(CityModel cityModel){
        return cityRepository.save(cityModel);
    }

    public Optional<CityModel> findById(Long id){
        return cityRepository.findById(id);
    }

    public List<CityModel> findAllByState(Long idState){
        return cityRepository.getAllByState(idState);
    }

    public void delete(Long id) throws Exception{
        Optional<CityModel> city = findById(id);
        if(city.get().getId() != null){
            cityRepository.delete(city.get());
        }else{
            throw new Exception("Cidade não existe!");
        }
    }
}
