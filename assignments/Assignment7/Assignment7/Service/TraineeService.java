package cg.example.Assignment7.Service;

import java.util.List;
import java.util.Optional;

import cg.example.Assignment7.entities.Trainee;

public interface TraineeService {
 public abstract List<Trainee> ListAllTrainee();
 public abstract List<Trainee> getTraineesByName(String name);
 public abstract Trainee getTraineeById(int id);
 public abstract void DeleteTrainee(int id);
 public abstract boolean Updatename(int id,String name);
 public abstract boolean Updatedomain(int id,String domain);
 public abstract boolean Updatelocation(int id,String Location);
 public abstract void InsertTrainee(Trainee t);

}
