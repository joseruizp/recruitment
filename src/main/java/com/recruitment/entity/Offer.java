package com.recruitment.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "OFERTA_LABORAL")
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Offer {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "titulo")
    private String title;

    @Column(name = "fecha_inicio_vigencia")
    private Date startDate;

    @Column(name = "fecha_fin_vigencia")
    private Date endDate;

    @Column(name = "salario")
    private double expectedSalary;

    @Column(name = "tipo_puesto")
    private String positionType;

    private String area;

    @Lob
    @Column(name = "texto_auncio")
    private String description;

    @Column(name = "fecha_creacion")
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "offer")
    private Set<JobApplication> appliedOffers;

}
