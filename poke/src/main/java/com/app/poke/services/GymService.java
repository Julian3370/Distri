package com.app.poke.services;

import com.app.poke.interfaces.GymRepository;
import com.app.poke.models.Gym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;

    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }

    public Optional<Gym> getGymById(Long id) {
        return gymRepository.findById(id);
    }

    public Gym createGym(Gym gym) {
        return gymRepository.save(gym);
    }

    public Gym updateGym(Gym gym) {
        return gymRepository.save(gym);
    }

    public void deleteGym(Long id) {
        gymRepository.deleteById(id);
    }
}
