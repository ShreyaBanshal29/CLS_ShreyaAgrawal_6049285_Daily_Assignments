package cg.example.Assignment7.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.example.Assignment7.Repo.TraineeRepo;
import cg.example.Assignment7.entities.Trainee;

@Service
public class TraineeServiceImpl implements TraineeService {
	@Autowired
   TraineeRepo tc;

	@Override
	public List<Trainee> ListAllTrainee() {
		return tc.findAll();
	}

	@Override
	public List<Trainee> getTraineesByName(String name) {
		return null;
	}

	@Override
	public Trainee getTraineeById(int id) {
		return tc.findById(id).orElse(null);
	}

	@Override
	public void DeleteTrainee(int id) {
		tc.deleteById(id);
	
	}

	@Override
	public boolean Updatename(int id, String name) {
	    Trainee t = tc.findById(id).orElse(null);
	    if(t==null)
	    	return false;
	    t.setTraineeName(name);
		tc.save(t);
		return true;
	}

	@Override
	public boolean Updatedomain(int id, String domain) {
		 Trainee t = tc.findById(id).orElse(null);
		    if(t==null)
		    	return false;
		    t.setTraineeDomain(domain);
			tc.save(t);
			return true;
	}

	@Override
	public boolean Updatelocation(int id, String Location) {
		 Trainee t = tc.findById(id).orElse(null);
		    if(t==null)
		    	return false;
		    t.setTraineeLocation(Location);
			tc.save(t);
			return true;
	}

	@Override
	public void InsertTrainee(Trainee t) {
		tc.save(t);
	}
}
