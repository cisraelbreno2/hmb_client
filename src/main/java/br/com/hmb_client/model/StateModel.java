package br.com.hmb_client.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "state")
public class StateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
