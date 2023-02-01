package uk.bs338.codeclan.WhiskyTracker.repositories;

import uk.bs338.codeclan.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> findDistilleryByRegion(String region);
}
