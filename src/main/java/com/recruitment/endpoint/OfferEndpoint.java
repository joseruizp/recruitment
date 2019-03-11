package com.recruitment.endpoint;

import com.recruitment.dto.result.OfferResult;
import com.recruitment.entity.Offer;
import com.recruitment.service.OfferService;
import com.recruitment.dto.view.OfferView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class OfferEndpoint {

    private OfferService offerService;

    @Autowired
    public OfferEndpoint(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers")
    public List<OfferResult> retrieveAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/offers/{id}")
    @ApiOperation(value = "Find offer by id",
            notes = "Also returns a link to retrieve all offers with rel - all-offers")
    public Resource<OfferResult> getOffer(@PathVariable long id) {
        OfferResult offer = offerService.getOffer(id);

        Resource<OfferResult> resource = new Resource<>(offer);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllOffers());

        resource.add(linkTo.withRel("all-offers"));

        return resource;
    }

    @PostMapping("/offers/")
    public ResponseEntity<Object> createOffer(@RequestBody OfferView offerView) {

        offerService.saveOffer(offerView);

        return ResponseEntity.noContent().build();
    }
}
