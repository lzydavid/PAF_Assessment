package ibf2022.paf.assessment.server;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner{

	@Autowired
	UserRepository repo;
	@Autowired
	TaskRepository taskRepo;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		//test findUSerByUSername
		// Optional<User> opt =  repo.findUSerByUSername("fred");
		// System.out.println(opt.get());

		//test insert user
		// User user = new User();
		// user.setUsername("kyle");
		// user.setName("Kyle");
		// System.out.println(repo.insertUser(user));

		//get user_id
		//System.out.println(taskRepo.getUserIdSQL("betty"));

		//test user exist
		//System.out.println(repo.checkIfUserExist("betty"));;

	}
}
