package br.com.hmb_client.dto;

import br.com.hmb_client.model.CityModel;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class AddressDto {

    private Long id;
    private String road;
    private String district;
    private String number;
    private Long city;
}
