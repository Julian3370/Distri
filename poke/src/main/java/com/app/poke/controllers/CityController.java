package com.app.poke.controllers;

import com.app.poke.models.City;
import com.app.poke.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id).orElse(null);
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@RequestBody City city, @PathVariable Long id) {
        city.setId(id);
        return cityService.updateCity(city);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        Map<String, String> response = new HashMap<>();
        response.put("response", "Ciudad con id " + id + " borrada correctamente");
        return response;
    }
}
