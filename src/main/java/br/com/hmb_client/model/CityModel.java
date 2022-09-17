package br.com.hmb_client.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "city")
public class CityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateModel state;
}
