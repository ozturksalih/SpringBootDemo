package in.carRental.controller;


import in.carRental.entity.CarDTO;
import in.carRental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private CarRepository _carRepository;

    @GetMapping("cars")
    public ResponseEntity<?> getAll(){
        List<CarDTO> cars = _carRepository.findAll();
        if(cars.size()>0){
            return new ResponseEntity<List<CarDTO>>(cars, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Car in the database",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("cars")
    public ResponseEntity<?> create(@RequestBody CarDTO car){
        try{
            car.setCreatedAt();
            _carRepository.save(car);
            return new ResponseEntity<CarDTO>(car,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("cars/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        Optional<CarDTO> carOptional = _carRepository.findById(id);
        if(carOptional.isPresent()){
            return new ResponseEntity<>(carOptional.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Couldn't find car with ID :" +id,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("cars/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody CarDTO car ){
        Optional<CarDTO> carOptional= _carRepository.findById(id);

        if(carOptional.isPresent()){
            CarDTO carToUpdate = carOptional.get();
            carToUpdate.setBrand(car.getBrand() != null ? car.getBrand() : carToUpdate.getBrand());
            carToUpdate.setModel(car.getModel() != null ? car.getModel() : carToUpdate.getModel());
            carToUpdate.setModelYear(car.getModelYear() != null ? car.getModelYear() : carToUpdate.getModelYear());
            carToUpdate.setDailyPrice(car.getDailyPrice() != null ? car.getDailyPrice() : carToUpdate.getDailyPrice());
            carToUpdate.setUpdatedAt();
            _carRepository.save(carToUpdate);
            return new ResponseEntity<>(carToUpdate,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Couldn't find car with ID :"+ id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("cars/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        Optional<CarDTO> carOptional = _carRepository.findById(id);
        if(carOptional.isPresent()){
            _carRepository.deleteById(id);
            return new ResponseEntity<>(carOptional.get().getBrand() + " Deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Couldn't find car with ID :" +id,HttpStatus.NOT_FOUND);
        }
    }

}
