package edu.cscc.controller;

import edu.cscc.model.Vinyl;

import edu.cscc.repository.VinylRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author David Geier
 * @version November 17th, 2024
 */

@Controller
public class VinylController {

    @Autowired
    private VinylRepository vinylRepository;

    @GetMapping("/records")
    public String viewAllRecords(Model model) {

        List<Vinyl> records = (List<Vinyl>) vinylRepository.findAll();
        model.addAttribute("records", records);
        return "records";

    }

    @GetMapping("/records/{id}")
    public String viewRecordDetails(@PathVariable Long id, Model model) {

        Vinyl vinyl = vinylRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid record ID: " + id));
        model.addAttribute("vinyl", vinyl);
        return "record"; // Name of your Thymeleaf template for record details

    }

    @GetMapping("/add-record")
    public String showAddRecordForm(Model model) {

        model.addAttribute("vinyl", new Vinyl());
        return "add-record";

    }

    @PostMapping("/add-record")
    public String addRecord(@Valid @ModelAttribute Vinyl vinyl, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "add-record";
        }

        Vinyl savedVinyl = vinylRepository.save(vinyl);
        return "redirect:/records/" + savedVinyl.getId();

    }
}