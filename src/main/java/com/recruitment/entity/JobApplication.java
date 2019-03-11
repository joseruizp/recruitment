package com.recruitment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "APLICACION_OFERTA")
public class JobApplication {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "fecha_postulacion")
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oferta_laboral_id")
    private Offer offer = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postulante_id")
    private Applicant applicant = null;
}
