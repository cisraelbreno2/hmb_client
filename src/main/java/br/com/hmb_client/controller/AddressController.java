package br.com.hmb_client.controller;

import br.com.hmb_client.dto.StateDto;
import br.com.hmb_client.model.CityModel;
import br.com.hmb_client.model.StateModel;
import br.com.hmb_client.service.AddressService;
import br.com.hmb_client.service.CityService;
import br.com.hmb_client.service.ClientService;
import br.com.hmb_client.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {


    @Autowired
    AddressService addressService;

    @Autowired
    StateService stateService;

    @Autowired
    CityService cityService;


    @PostMapping("/address/save")
    public ResponseEntity saveCitysAndStates(@RequestBody List<StateDto> estados){

        for (StateDto state: estados) {
            StateModel stateModel = new StateModel();
            stateModel.setName(state.getNome());
            stateModel = stateService.save(stateModel);

            for ( String city: state.getCidades() ) {
                CityModel cityModel = new CityModel();
                cityModel.setName(city);
                cityModel.setState(stateModel);
                cityService.save(cityModel);
            }
        }

        return new ResponseEntity(HttpStatus.CREATED);

    }
}
