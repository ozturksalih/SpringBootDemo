package in.carRental.repository;

import in.carRental.entity.CarDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<CarDTO,String> {
}
