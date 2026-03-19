package cg.example.Assignment7.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.example.Assignment7.entities.Trainee;

@Repository
public interface TraineeRepo extends JpaRepository<Trainee,Integer>{
	
}
