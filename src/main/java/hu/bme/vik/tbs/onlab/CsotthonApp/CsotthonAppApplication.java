package hu.bme.vik.tbs.onlab.CsotthonApp;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.ScoutGroup;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.User;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.ScoutGroupRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.UserRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsotthonAppApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ScoutGroupRepository scoutGroupRepository;

	public static void main(String[] args) {

		SpringApplication.run(CsotthonAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TESZTADATOK
		ScoutGroup scoutGroup1=ScoutGroup.builder().name("Levendula").sex(Sex.FEMALE).build();

		User user1= User.builder().name("Tóth-Baranyi Stella").email("stella@email.com").password("pw").scoutGroup(scoutGroup1).group_leader(true).scout(true).build();

		scoutGroupRepository.save(scoutGroup1);
		userRepository.save(user1);
	}
}
