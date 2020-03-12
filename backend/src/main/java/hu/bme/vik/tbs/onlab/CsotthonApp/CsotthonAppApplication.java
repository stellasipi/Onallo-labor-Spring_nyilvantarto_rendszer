package hu.bme.vik.tbs.onlab.CsotthonApp;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.CleaningItem;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Room;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.ScoutGroup;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.User;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.CleaningItemRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.RoomRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.ScoutGroupRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.UserRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CsotthonAppApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ScoutGroupRepository scoutGroupRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	CleaningItemRepository cleaningItemRepository;

	public static void main(String[] args) {

		SpringApplication.run(CsotthonAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//test data
		ScoutGroup scoutGroup1=ScoutGroup.builder().name("Levendula").sex(Sex.FEMALE).build();

		User user1= User.builder()
				.name("Tóth-Baranyi Stella")
				.email("stella@email.com")
				.password("pw")
				.scoutGroup(scoutGroup1)
				.groupLeader(true)
				.scout(true)
				.build();

		scoutGroupRepository.save(scoutGroup1);
		userRepository.save(user1);

		//cleaning section NOT TEST
		List<String> rooms=new ArrayList<>(Arrays.asList("Basement","BigRoom","Kitchen","MiddleRoom","RestRoom"));
		List<String> cleaningItems=new ArrayList<>(Arrays.asList("felmosás","rekeszek","lomok","elrendezés","konyhapult","konyhabútor","mosogatás","faliujság","vitrin","raktár","tiszta","wcpapír","törülköző"));

		for(String room:rooms){
			Room roomToPersist=Room.builder().name(room).build();
			roomRepository.save(roomToPersist);
		}

		for(String cleaningItem:cleaningItems){
			CleaningItem cleaningItemToPersist=CleaningItem.builder().name(cleaningItem).build();
			cleaningItemRepository.save(cleaningItemToPersist);
		}
	}
}
