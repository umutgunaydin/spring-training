package com.company.repository;

import com.company.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    //display all regions in Canada
    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country); // find-get-read all of are same


    //display all regions with country name includes 'United'
    List<Region> findByCountryContains(String country);

    // display all regions with country name includes 'United' in order(region)
    List<Region> findByCountryContainsOrderByRegionDesc(String country);

    //display top 2 regions in United States
    List<Region> findTopByCountry(String country);
    List<Region> findTop2ByCountry(String country);

}
