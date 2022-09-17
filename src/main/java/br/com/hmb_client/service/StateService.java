package br.com.hmb_client.service;


import br.com.hmb_client.model.StateModel;
import br.com.hmb_client.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    public StateModel save(StateModel stateModel){
        return stateRepository.save(stateModel);
    }

    public Optional<StateModel> findById(Long id){
        return stateRepository.findById(id);
    }

    public List<StateModel> findAll(){
        return stateRepository.findAll();
    }

    public void delete(Long id) throws Exception{
        Optional<StateModel> state = findById(id);
        if(state.get().getId() != null){
            stateRepository.delete(state.get());
        }else{
            throw new Exception("Estado não existe!");
        }
    }
}
