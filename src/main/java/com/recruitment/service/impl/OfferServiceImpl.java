package com.recruitment.service.impl;

import com.recruitment.dto.result.OfferResult;
import com.recruitment.dto.util.ResultUtil;
import com.recruitment.entity.Company;
import com.recruitment.entity.Offer;
import com.recruitment.repository.OfferRepository;
import com.recruitment.service.CompanyService;
import com.recruitment.service.OfferService;
import com.recruitment.dto.view.OfferView;
import com.recruitment.dto.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private CompanyService companyService;
    private OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, CompanyService companyService) {
        this.offerRepository = offerRepository;
        this.companyService = companyService;
    }

    @Override
    public OfferResult getOffer(long offerId) {
        Optional<Offer> offer = offerRepository.findById(offerId);

        if (!offer.isPresent())
            throw new RuntimeException("offerta no encontrada con id: " + offerId);

        return ResultUtil.toOffer(offer.get());
    }

    @Override
    @Transactional
    public long saveOffer(OfferView offerView) {

        Company company = companyService.getCompany(offerView.getCompanyId());

        Offer offer = ViewUtil.toOffer(offerView);
        offer.setCompany(company);

        Offer savedOffer = offerRepository.save(offer);

        return savedOffer.getId();
    }

    @Override
    public List<OfferResult> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        return ResultUtil.toOffers(offers);
    }
}
