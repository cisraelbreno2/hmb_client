package br.com.hmb_client.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String road;
    private String district;
    private String number;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityModel city;

}
