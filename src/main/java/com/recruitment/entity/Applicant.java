package com.recruitment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "POSTULANTE")
@Getter
@Setter
@NoArgsConstructor
public class Applicant {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "sexo")
    private String gender;

    @Column(name = "fecha_nacimiento")
    private Date birthDate;

    @Column(name = "resumen")
    private String resume;

    @Column(name = "cuenta_linkedin")
    private String linkedInAccount;

    @Column(name = "foto")
    private String photo;

    @Column(name = "telefono_fijo")
    private String phoneNumber;

    @Column(name = "celular")
    private String cellphoneNumber;

    @Column(name = "direccion")
    private String address;

    @Column(name = "ubigeo")
    private String ubigeoCode; // from reniec

    @Column(name = "grado_instruccion")
    private String degree;

    @Column(name = "profesion")
    private String profession;

    @Column(name = "intereses")
    private String interests; // must be a list i guess??

    @Lob
    @Column(name = "cv")
    private byte[] cv;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicantUserId", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "applicant")
    private Set<JobApplication> appliedOffers;

}
