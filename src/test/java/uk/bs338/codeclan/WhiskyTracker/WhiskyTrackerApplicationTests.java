package uk.bs338.codeclan.WhiskyTracker;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import uk.bs338.codeclan.WhiskyTracker.models.Whisky;
import uk.bs338.codeclan.WhiskyTracker.repositories.DistilleryRepository;
import uk.bs338.codeclan.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge(){
		List<Whisky> whiskies = whiskyRepository.findWhiskyByAgeAndDistilleryName(15, "Glendronach");
//		assertEquals(1, whiskies.size());
		assertEquals(15, whiskies.get(0).getAge());
		assertEquals("Glendronach", whiskies.get(0).getDistillery().getName());
	}

}
