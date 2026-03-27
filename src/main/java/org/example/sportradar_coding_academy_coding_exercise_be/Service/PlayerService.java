package org.example.sportradar_coding_academy_coding_exercise_be.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Player;
import org.example.sportradar_coding_academy_coding_exercise_be.Repository.PlayerRepo;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private PlayerRepo repo;

    public PlayerService(PlayerRepo repo) {
        this.repo = repo;
    }

    public void add(Player player) {
        repo.save(player);
    }

    public void update(Player player) {
        repo.save(player);
    }

    public void delete(Player player) {
        repo.delete(player);
    }

    public Player getById(long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Player with id " + id + " not found!"));
    }
}
