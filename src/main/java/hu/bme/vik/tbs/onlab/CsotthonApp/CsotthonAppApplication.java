package hu.bme.vik.tbs.onlab.CsotthonApp;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.Sex;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

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

	@Autowired
	CleaningRepository cleaningRepository;

	@Autowired
	RoomCleaningRepository roomCleaningRepository;

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
				//.time(new Timestamp(System.currentTimeMillis()))
				.time(Time.getNowInUTC())
				.comment("Minden rendben")
				.type(LogType.OPENING)
				.user(user1)
				.build();

		Log log2 = Log.builder()
				.time(Time.getSpecificTimeInUTC(2020,Calendar.MARCH,24,12,30)/*new Timestamp(new GregorianCalendar(2020, 3, 24,12,30,00).getTimeInMillis())*/)
				.type(LogType.CLOSING)
				.user(user1)
				.build();

		List<Log> logs = Arrays.asList(log1,log2);
		user1.setLogs(logs);

		Maintenance maintenance = Maintenance.builder()
				.time(Time.getNowInUTC())
				.user(user1)
				.comment("Elfogyott a wcpapír és kéne egy felmosás.")
				.build();

		scoutGroupRepository.save(scoutGroup1);
		userRepository.save(user1);
		logRepository.saveAll(logs);
		maintenanceRepository.save(maintenance);

		//cleaning section NOT TEST
		List<String> rooms=new ArrayList<>(Arrays.asList("Pince","Nagy terem","Konyha","Középső terem","Mosdók"));
		List<String> cleaningItems=new ArrayList<>(Arrays.asList("felmosás","rekeszek","lomok","elrendezés","konyhapult","konyhabútor","mosogatás","faliujság","vitrin","raktár","tiszta kagylók","wcpapír","törülköző"));

		for(String room:rooms){
			Room roomToPersist=Room.builder().name(room).build();
			roomRepository.save(roomToPersist);
		}

		for(String cleaningItem:cleaningItems){
			CleaningItem cleaningItemToPersist=CleaningItem.builder().name(cleaningItem).build();
			cleaningItemRepository.save(cleaningItemToPersist);
		}

		//cleaning TEST data 1
		Cleaning cleaning1=Cleaning.builder()
				.scoutGroup(scoutGroup1)
				.user(user1)
				.time(Time.getNowInUTC())
				.build();

		user1.setCleanings(Arrays.asList(cleaning1));
		scoutGroup1.setCleanings(Arrays.asList(cleaning1));

		cleaningRepository.save(cleaning1);

		cleaning1=cleaningRepository.findById(cleaning1.getId()).get();

		RoomCleaning roomCleaning1=RoomCleaning.builder().done(true).build(); roomCleaning1.setRoom(roomRepository.findByName("Pince")); roomCleaning1.setCleaning(cleaning1); roomCleaning1.setCleaningItem(cleaningItemRepository.findByName("rekeszek"));
		RoomCleaning roomCleaning2=RoomCleaning.builder().done(true).build(); roomCleaning2.setRoom(roomRepository.findByName("Pince")); roomCleaning2.setCleaning(cleaning1); roomCleaning2.setCleaningItem(cleaningItemRepository.findByName("felmosás"));
		RoomCleaning roomCleaning3=RoomCleaning.builder().done(false).build(); roomCleaning3.setRoom(roomRepository.findByName("Nagy terem")); roomCleaning3.setCleaning(cleaning1); roomCleaning3.setCleaningItem(cleaningItemRepository.findByName("lomok"));
		RoomCleaning roomCleaning4=RoomCleaning.builder().done(true).build(); roomCleaning4.setRoom(roomRepository.findByName("Nagy terem")); roomCleaning4.setCleaning(cleaning1); roomCleaning4.setCleaningItem(cleaningItemRepository.findByName("elrendezés"));
		RoomCleaning roomCleaning5=RoomCleaning.builder().done(true).build(); roomCleaning5.setRoom(roomRepository.findByName("Nagy terem")); roomCleaning5.setCleaning(cleaning1); roomCleaning5.setCleaningItem(cleaningItemRepository.findByName("felmosás"));
		RoomCleaning roomCleaning6=RoomCleaning.builder().done(true).build(); roomCleaning6.setRoom(roomRepository.findByName("Konyha")); roomCleaning6.setCleaning(cleaning1); roomCleaning6.setCleaningItem(cleaningItemRepository.findByName("konyhapult"));
		RoomCleaning roomCleaning7=RoomCleaning.builder().done(false).build(); roomCleaning7.setRoom(roomRepository.findByName("Konyha")); roomCleaning7.setCleaning(cleaning1); roomCleaning7.setCleaningItem(cleaningItemRepository.findByName("konyhabútor"));
		RoomCleaning roomCleaning8=RoomCleaning.builder().done(true).build(); roomCleaning8.setRoom(roomRepository.findByName("Konyha")); roomCleaning8.setCleaning(cleaning1); roomCleaning8.setCleaningItem(cleaningItemRepository.findByName("mosogatás"));
		RoomCleaning roomCleaning9=RoomCleaning.builder().done(true).build(); roomCleaning9.setRoom(roomRepository.findByName("Konyha")); roomCleaning9.setCleaning(cleaning1); roomCleaning9.setCleaningItem(cleaningItemRepository.findByName("felmosás"));
		RoomCleaning roomCleaning10=RoomCleaning.builder().done(false).build();roomCleaning10.setRoom(roomRepository.findByName("Középső terem")); roomCleaning10.setCleaning(cleaning1); roomCleaning10.setCleaningItem(cleaningItemRepository.findByName("elrendezés"));
		RoomCleaning roomCleaning11=RoomCleaning.builder().done(true).build(); roomCleaning11.setRoom(roomRepository.findByName("Középső terem")); roomCleaning11.setCleaning(cleaning1); roomCleaning11.setCleaningItem(cleaningItemRepository.findByName("faliujság"));
		RoomCleaning roomCleaning12=RoomCleaning.builder().done(true).build(); roomCleaning12.setRoom(roomRepository.findByName("Középső terem")); roomCleaning12.setCleaning(cleaning1); roomCleaning12.setCleaningItem(cleaningItemRepository.findByName("vitrin"));
		RoomCleaning roomCleaning13=RoomCleaning.builder().done(true).build(); roomCleaning13.setRoom(roomRepository.findByName("Középső terem")); roomCleaning13.setCleaning(cleaning1); roomCleaning13.setCleaningItem(cleaningItemRepository.findByName("raktár"));
		RoomCleaning roomCleaning14=RoomCleaning.builder().done(false).build(); roomCleaning14.setRoom(roomRepository.findByName("Középső terem")); roomCleaning14.setCleaning(cleaning1); roomCleaning14.setCleaningItem(cleaningItemRepository.findByName("felmosás"));
		RoomCleaning roomCleaning15=RoomCleaning.builder().done(true).build(); roomCleaning15.setRoom(roomRepository.findByName("Mosdók")); roomCleaning15.setCleaning(cleaning1); roomCleaning15.setCleaningItem(cleaningItemRepository.findByName("tiszta kagylók"));
		RoomCleaning roomCleaning16=RoomCleaning.builder().done(true).build(); roomCleaning16.setRoom(roomRepository.findByName("Mosdók")); roomCleaning16.setCleaning(cleaning1); roomCleaning16.setCleaningItem(cleaningItemRepository.findByName("wcpapír"));
		RoomCleaning roomCleaning17=RoomCleaning.builder().done(true).build(); roomCleaning17.setRoom(roomRepository.findByName("Mosdók")); roomCleaning17.setCleaning(cleaning1); roomCleaning17.setCleaningItem(cleaningItemRepository.findByName("törülköző"));
		RoomCleaning roomCleaning18=RoomCleaning.builder().done(true).build(); roomCleaning18.setRoom(roomRepository.findByName("Mosdók")); roomCleaning18.setCleaning(cleaning1); roomCleaning18.setCleaningItem(cleaningItemRepository.findByName("felmosás"));

		List<RoomCleaning> roomCleanings = new ArrayList<>(Arrays.asList(
				roomCleaning1, roomCleaning2, roomCleaning3,
				roomCleaning4, roomCleaning5, roomCleaning6,
				roomCleaning7, roomCleaning8, roomCleaning9,
				roomCleaning10, roomCleaning11, roomCleaning12,
				roomCleaning13, roomCleaning14, roomCleaning15,
				roomCleaning16, roomCleaning17, roomCleaning18));

		roomCleaningRepository.saveAll(roomCleanings);

		//cleaning TEST data 2
		Cleaning cleaning2=Cleaning.builder()
				.scoutGroup(scoutGroup1)
				.user(user1)
				.time(Time.getSpecificTimeInUTC(2020,Calendar.APRIL,4,12,30))
				.build();

		user1.setCleanings(Arrays.asList(cleaning2));
		scoutGroup1.setCleanings(Arrays.asList(cleaning2));

		cleaningRepository.save(cleaning2);

		cleaning2=cleaningRepository.findById(cleaning2.getId()).get();

		RoomCleaning roomCleaning19=RoomCleaning.builder().done(false).build(); roomCleaning19.setRoom(roomRepository.findByName("Pince")); roomCleaning19.setCleaning(cleaning2); roomCleaning19.setCleaningItem(cleaningItemRepository.findByName("rekeszek"));
		RoomCleaning roomCleaning20=RoomCleaning.builder().done(false).build(); roomCleaning20.setRoom(roomRepository.findByName("Pince")); roomCleaning20.setCleaning(cleaning2); roomCleaning20.setCleaningItem(cleaningItemRepository.findByName("felmosás"));
		RoomCleaning roomCleaning21=RoomCleaning.builder().done(false).build(); roomCleaning21.setRoom(roomRepository.findByName("Nagy terem")); roomCleaning21.setCleaning(cleaning2); roomCleaning21.setCleaningItem(cleaningItemRepository.findByName("lomok"));
		RoomCleaning roomCleaning22=RoomCleaning.builder().done(false).build(); roomCleaning22.setRoom(roomRepository.findByName("Nagy terem")); roomCleaning22.setCleaning(cleaning2); roomCleaning22.setCleaningItem(cleaningItemRepository.findByName("elrendezés"));
		RoomCleaning roomCleaning23=RoomCleaning.builder().done(false).build(); roomCleaning23.setRoom(roomRepository.findByName("Nagy terem")); roomCleaning23.setCleaning(cleaning2); roomCleaning23.setCleaningItem(cleaningItemRepository.findByName("felmosás"));
		RoomCleaning roomCleaning24=RoomCleaning.builder().done(false).build(); roomCleaning24.setRoom(roomRepository.findByName("Konyha")); roomCleaning24.setCleaning(cleaning2); roomCleaning24.setCleaningItem(cleaningItemRepository.findByName("konyhapult"));
		RoomCleaning roomCleaning25=RoomCleaning.builder().done(false).build(); roomCleaning25.setRoom(roomRepository.findByName("Konyha")); roomCleaning25.setCleaning(cleaning2); roomCleaning25.setCleaningItem(cleaningItemRepository.findByName("konyhabútor"));
		RoomCleaning roomCleaning26=RoomCleaning.builder().done(false).build(); roomCleaning26.setRoom(roomRepository.findByName("Konyha")); roomCleaning26.setCleaning(cleaning2); roomCleaning26.setCleaningItem(cleaningItemRepository.findByName("mosogatás"));
		RoomCleaning roomCleaning27=RoomCleaning.builder().done(false).build(); roomCleaning27.setRoom(roomRepository.findByName("Konyha")); roomCleaning27.setCleaning(cleaning2); roomCleaning27.setCleaningItem(cleaningItemRepository.findByName("felmosás"));
		RoomCleaning roomCleaning28=RoomCleaning.builder().done(false).build();roomCleaning28.setRoom(roomRepository.findByName("Középső terem")); roomCleaning28.setCleaning(cleaning2); roomCleaning28.setCleaningItem(cleaningItemRepository.findByName("elrendezés"));
		RoomCleaning roomCleaning29=RoomCleaning.builder().done(true).build(); roomCleaning29.setRoom(roomRepository.findByName("Középső terem")); roomCleaning29.setCleaning(cleaning2); roomCleaning29.setCleaningItem(cleaningItemRepository.findByName("faliujság"));
		RoomCleaning roomCleaning30=RoomCleaning.builder().done(false).build(); roomCleaning30.setRoom(roomRepository.findByName("Középső terem")); roomCleaning30.setCleaning(cleaning2); roomCleaning30.setCleaningItem(cleaningItemRepository.findByName("vitrin"));
		RoomCleaning roomCleaning31=RoomCleaning.builder().done(true).build(); roomCleaning31.setRoom(roomRepository.findByName("Középső terem")); roomCleaning31.setCleaning(cleaning2); roomCleaning31.setCleaningItem(cleaningItemRepository.findByName("raktár"));
		RoomCleaning roomCleaning32=RoomCleaning.builder().done(false).build(); roomCleaning32.setRoom(roomRepository.findByName("Középső terem")); roomCleaning32.setCleaning(cleaning2); roomCleaning32.setCleaningItem(cleaningItemRepository.findByName("felmosás"));
		RoomCleaning roomCleaning33=RoomCleaning.builder().done(true).build(); roomCleaning33.setRoom(roomRepository.findByName("Mosdók")); roomCleaning33.setCleaning(cleaning2); roomCleaning33.setCleaningItem(cleaningItemRepository.findByName("tiszta kagylók"));
		RoomCleaning roomCleaning34=RoomCleaning.builder().done(true).build(); roomCleaning34.setRoom(roomRepository.findByName("Mosdók")); roomCleaning34.setCleaning(cleaning2); roomCleaning34.setCleaningItem(cleaningItemRepository.findByName("wcpapír"));
		RoomCleaning roomCleaning35=RoomCleaning.builder().done(true).build(); roomCleaning35.setRoom(roomRepository.findByName("Mosdók")); roomCleaning35.setCleaning(cleaning2); roomCleaning35.setCleaningItem(cleaningItemRepository.findByName("törülköző"));
		RoomCleaning roomCleaning36=RoomCleaning.builder().done(true).build(); roomCleaning36.setRoom(roomRepository.findByName("Mosdók")); roomCleaning36.setCleaning(cleaning2); roomCleaning36.setCleaningItem(cleaningItemRepository.findByName("felmosás"));

		List<RoomCleaning> roomCleanings2 = new ArrayList<>(Arrays.asList(
				roomCleaning19, roomCleaning20, roomCleaning21,
				roomCleaning22, roomCleaning23, roomCleaning24,
				roomCleaning25, roomCleaning26, roomCleaning27,
				roomCleaning28, roomCleaning29, roomCleaning30,
				roomCleaning31, roomCleaning32, roomCleaning33,
				roomCleaning34, roomCleaning35, roomCleaning36));

		roomCleaningRepository.saveAll(roomCleanings2);


	}


}
