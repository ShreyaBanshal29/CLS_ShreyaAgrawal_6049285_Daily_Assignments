package com.example.Assignment7.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;

import com.example.Assignment7.entities.Trainee;
import com.example.Assignment7.repositories.ITraineeRepository;

public interface ITraineeService {
    Trainee addTrainee(Trainee t);
    boolean deleteTrainee(int id);
    Trainee updateTrainee(int id, Trainee t);
    Optional<Trainee> getTrainee(int id);
    List<Trainee> getAllTrainees();
    Optional<Trainee> findBytraineeName(String name);


}
