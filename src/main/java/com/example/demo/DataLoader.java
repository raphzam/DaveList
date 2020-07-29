package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ListingRepository listingRepository;

    @Override
    public void run(String...strings) throws Exception {

        Listing listing1 = new Listing();
        listing1.setTitle("Modern Apartment");
        listing1.setAddress("2000 Bryant ST NW");
        listing1.setState("DC");
        listing1.setPrice(2500);
//        listing1.setCable();
//        listing1.setDescription();
//        listing1.setPrivateBathroom();
        listing1.setRented(true);
//        listing1.setRules();
//        listing1.setWifi();
        listingRepository.save(listing1);

        Listing listing2 = new Listing();
        listing2.setTitle("Luxury Apartment");
        listing2.setAddress("1235 Georgia Ave NW");
        listing2.setState("DC");
        listing2.setPrice(3500);
//        listing2.setCable();
//        listing2.setDescription();
//        listing2.setPrivateBathroom();
        listing2.setRented(false);
//        listing2.setRules();
//        listing2.setWifi();
        listingRepository.save(listing2);

//        Listing listing3 = new Listing();
//        listing3.setTitle();
//        listing3.setAddress();
//        listing3.setState();
//        listing3.setPrice();
//        listing3.setCable();
//        listing3.setDescription();
//        listing3.setPrivateBathroom();
//        listing3.setRented(true);
//        listing3.setRules();
//        listing3.setWifi();
//        listingRepository.save(listing3);



    }
}
