package com.recruitment.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "EMPRESA")
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nombre")
    private String name;

    private String ruc;

    @Column(name = "razon_social")
    private String businessName; // razon social

    @Column(name = "rubro")
    private String sector;

    @Column(name = "link_web")
    private String url;

    @Column(name = "link_video")
    private String videoLink;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyUser", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<Offer> offers = null;

    public Set<Offer> getOffers() {
        return null;
    }

}
