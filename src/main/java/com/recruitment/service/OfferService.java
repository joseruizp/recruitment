package com.recruitment.service;

import com.recruitment.dto.result.OfferResult;
import com.recruitment.entity.Offer;
import com.recruitment.dto.view.OfferView;

import java.util.List;

public interface OfferService {

    OfferResult getOffer(long offerId);
    long saveOffer(OfferView offerView);
    List<OfferResult> getAllOffers();
}
