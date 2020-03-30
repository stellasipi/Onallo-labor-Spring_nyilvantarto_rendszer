package hu.bme.vik.tbs.onlab.CsotthonApp;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
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

	@Autowired
	LogRepository logRepository;

	@Autowired
	MaintenanceRepository maintenanceRepository;

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

		Log log1 = Log.builder()
				.time(new Timestamp(System.currentTimeMillis()))
				.comment("Minden rendben")
				.type(LogType.OPENING)
				.user(user1)
				.build();

		Log log2 = Log.builder()
				.time(new Timestamp(new GregorianCalendar(2020, 3, 24,12,30,00).getTimeInMillis()))
				.type(LogType.CLOSING)
				.user(user1)
				.build();

		List<Log> logs = Arrays.asList(log1,log2);
		user1.setLogs(logs);

		Maintenance maintenance = Maintenance.builder()
				.time(new Timestamp(System.currentTimeMillis()))
				.user(user1)
				.comment("Elfogyott a wcpapír és kéne egy felmosás.")
				.build();

		scoutGroupRepository.save(scoutGroup1);
		userRepository.save(user1);
		logRepository.saveAll(logs);
		maintenanceRepository.save(maintenance);

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
