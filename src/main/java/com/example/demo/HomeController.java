package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    ListingRepository listingRepository;

    @Autowired
    UserRepository userRepository;


//    ADMIN VIEWS

    @RequestMapping("/admin/home")
    public String loadAdminHome(Model model, Principal principal) {//home page shows all listings
        model.addAttribute("listings", listingRepository.findAll());
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        return "adminhome";
    }

    @GetMapping("/admin/newlisting")
    public String loadListingForm(Model model) {
        model.addAttribute("listing", new Listing());
        return "listingform";
    }

    @PostMapping("/admin/processlisting")
    public String processListing(@ModelAttribute Listing listing, Model model) {
        listingRepository.save(listing);
        return "redirect:/";
    }

    @RequestMapping("/admin/updatelisting/{id}")
    public String updateListing(@PathVariable("id") long id, Model model) {
        model.addAttribute("listing", listingRepository.findById(id).get());
        return "listingform";
    }

    @RequestMapping("/admin/togglerented/{id}")
    public String toggleRented(@PathVariable("id") long id, Model model) {
        Listing listing = new Listing();
        listing = listingRepository.findById(id).get();

        boolean rented = listing.isRented();
        listing.setRented(!rented);

        listingRepository.save(listing);

        return "redirect:/admin/home";
    }

//    PUBLIC VIEWS

    @RequestMapping("/login")
    public String loadHomePage() {//home page shows all listings
        return "login";
    }

    @RequestMapping("/")
    public String loadHomePage(Model model, Principal principal) {//home page shows all listings
        String username;
        if (principal != null) {
            username = principal.getName();
            User user = userRepository.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("listings", listingRepository.findAll());
        return "home";
    }

    @GetMapping("/listing/{id}")
    public String viewListing(@PathVariable("id") long id, Model model) {
        model.addAttribute("listing", listingRepository.findById(id).get());
        return "listingdetail";
    }


}
