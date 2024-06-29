package com.app.poke.controllers;

import com.app.poke.models.Trainer;
import com.app.poke.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{id}")
    public Trainer getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id).orElse(null);
    }

    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerService.createTrainer(trainer);
    }

    @PutMapping("/{id}")
    public Trainer updateTrainer(@RequestBody Trainer trainer, @PathVariable Long id) {
        trainer.setId(id);
        return trainerService.updateTrainer(trainer);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        Map<String, String> response = new HashMap<>();
        response.put("response", "Entrenador con id " + id + " borrado correctamente");
        return response;
    }
}
