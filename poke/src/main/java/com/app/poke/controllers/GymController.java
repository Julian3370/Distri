package com.app.poke.controllers;

import com.app.poke.models.Gym;
import com.app.poke.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/gyms")
public class GymController {

    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    public List<Gym> getAllGyms() {
        return gymService.getAllGyms();
    }

    @GetMapping("/{id}")
    public Gym getGymById(@PathVariable Long id) {
        return gymService.getGymById(id).orElse(null);
    }

    @PostMapping
    public Gym createGym(@RequestBody Gym gym) {
        return gymService.createGym(gym);
    }

    @PutMapping("/{id}")
    public Gym updateGym(@RequestBody Gym gym, @PathVariable Long id) {
        gym.setId(id);
        return gymService.updateGym(gym);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteGym(@PathVariable Long id) {
        gymService.deleteGym(id);
        Map<String, String> response = new HashMap<>();
        response.put("response", "Gimnasio con id " + id + " borrado correctamente");
        return response;
    }
}
