package com.recruitment.dto.util;

import com.recruitment.dto.result.KeyValueResult;
import com.recruitment.dto.result.OfferResult;
import com.recruitment.entity.Offer;

import java.util.List;
import java.util.stream.Collectors;

public final class ResultUtil {

    public static List<OfferResult> toOffers(List<Offer> offers) {
        return offers.stream().map(ResultUtil::toOffer).collect(Collectors.toList());
    }

    public static OfferResult toOffer(Offer offer) {
        OfferResult offerResult = new OfferResult();
        offerResult.setId(offer.getId());
        offerResult.setTitle(offer.getTitle());
        offerResult.setStartDate(offer.getStartDate());
        offerResult.setEndDate(offer.getEndDate());
        offerResult.setExpectedSalary(offer.getExpectedSalary());
        offerResult.setPositionType(offer.getPositionType());
        offerResult.setArea(offer.getArea());
        offerResult.setDescription(offer.getDescription());
        offerResult.setCompany(new KeyValueResult(offer.getCompany().getId(), offer.getCompany().getBusinessName()));
        return offerResult;
    }
}
