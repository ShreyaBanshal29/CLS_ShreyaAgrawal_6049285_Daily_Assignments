package cg.example.Assignment7;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cg.example.Assignment7.entities.Trainee;
import cg.example.Assignment7.Service.TraineeService;

@SpringBootApplication
public class Assignment7Application  implements CommandLineRunner {
	
	@Autowired
	TraineeService service; 

	public static void main(String[] args) {
		System.out.println("Application Context is Loaded!!!");
		SpringApplication.run(Assignment7Application.class, args);
	}

	@Override
    public void run(String... args) throws Exception {

		 Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nPick your operation:");
	            System.out.println("1. Add a Trainee");
	            System.out.println("2. Delete a Trainee");
	            System.out.println("3. Modify a Trainee");
	            System.out.println("4. Retrieve a Trainee by id");
	            System.out.println("5. Retrieve all Trainees");
	            System.out.println("6. Exit");

	            int choice = sc.nextInt();

	            switch (choice) {

	            case 1:
	                Trainee t = new Trainee();
	                System.out.print("Enter Name: ");
	                t.setTraineeName(sc.nextLine());

	                System.out.print("Enter Domain: ");
	                t.setTraineeDomain(sc.nextLine());

	                System.out.print("Enter Location: ");
	                t.setTraineeLocation(sc.nextLine());

	                service.InsertTrainee(t);
	                System.out.println("Trainee Added");
	                break;

	            case 2:
	                System.out.print("Enter ID to delete: ");
	                int id = sc.nextInt();
	                service.DeleteTrainee(id);
	                System.out.println("Deleted successfully");
	                break;

	            case 3:
	                System.out.print("Enter ID to update: ");
	                int uid = sc.nextInt();

	               
	                System.out.print("Enter New Name: ");
	                String name = sc.nextLine();

	             boolean updated = service.Updatename(uid, name);
	                if (updated)
	                    System.out.println("Updated successfully");
	                else
	                    System.out.println("Trainee not found");
	                break;

	            case 4:
	                System.out.print("Enter ID: ");
	                int rid = sc.nextInt();
	                Trainee tr = service.getTraineeById(rid);

	                if (tr != null)
	                    System.out.println(tr.getTraineeName() + " " + tr.getTraineeDomain());
	                else
	                    System.out.println("Not found");
	                break;

	            case 5:
	                List<Trainee> list = service.ListAllTrainee();
	                for (Trainee tt : list) {
	                    System.out.println(tt.getTraineeId() + " " + tt.getTraineeName());
	                }
	                break;

	            case 6:
	                System.exit(0);

	            default:
	                System.out.println("Invalid choice");
    }
	
	

	        	}
	}
}