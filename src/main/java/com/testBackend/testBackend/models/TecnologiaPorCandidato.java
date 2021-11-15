package com.testBackend.testBackend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tecnologias_por_candidato")
public class TecnologiaPorCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "anios_experiencia")
    @NonNull
    private  Integer  aniosExperiencias;

    @ManyToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    private Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "id_tecnologia", referencedColumnName = "id")
    private Tecnologia tecnologia;
}
