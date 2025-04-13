package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merge")
public class MergerController {

    DinerRepository dinerRepository;

    PancakeHouseRepository panCakeHouseRepository;

    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository panCakeHouseRepository){

        this.panCakeHouseRepository = panCakeHouseRepository;
        this.dinerRepository = dinerRepository;
    }

    @GetMapping
    public List<MenuItem> get() {

        MenuItem[] dinerMenuItems = dinerRepository.getTheMenu();
        List<MenuItem> panCakeHouseMenuItems = panCakeHouseRepository.getTheMenu();

        panCakeHouseMenuItems.addAll(Arrays.asList(dinerMenuItems));

        return panCakeHouseMenuItems;
    }
}