package uk.bs338.codeclan.WhiskyTracker.repositories;

import uk.bs338.codeclan.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskyByYear(int year);

    List<Whisky> findWhiskyByAgeAndDistilleryName(int age, String name);
}
