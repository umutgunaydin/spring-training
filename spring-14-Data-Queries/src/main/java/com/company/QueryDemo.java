package com.company;

import com.company.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;


    public QueryDemo(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("findByCountry:"+regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContains:"+regionRepository.findByCountryContains("United"));
        System.out.println("findByCountryContainsOrderByRegionDesc:"+regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("findTop2ByCountry:"+regionRepository.findTop2ByCountry("United States"));
    }
}
