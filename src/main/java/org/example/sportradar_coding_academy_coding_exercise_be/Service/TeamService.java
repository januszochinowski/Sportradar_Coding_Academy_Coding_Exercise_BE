package org.example.sportradar_coding_academy_coding_exercise_be.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Team;
import org.example.sportradar_coding_academy_coding_exercise_be.Repository.TeamRepo;

public class TeamService {

    private TeamRepo repo;

    public TeamService(TeamRepo repo) {
        this.repo = repo;
    }


    public void add(Team team) {
        repo.save(team);
    }

    public void delete(Team team) {
        repo.delete(team);
    }

    public void update(Team team) {
        repo.save(team);
    }

    public Team getById(long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Team with id " + id + " not found!"));
    }
}
