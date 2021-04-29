package in.carRental.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "cars")
public class CarDTO {
    @Id
    private String id ;
    private String Brand;
    private String Model;
    private String dailyPrice;
    private String modelYear;
    private Date createdAt;
    private Date updatedAt;

    public CarDTO() {
    }

    public CarDTO(String id, String brand,
                  String model, String dailyPrice,
                  String modelYear, Date createdAt, Date updatedAt) {
        this.id = id;
        Brand = brand;
        Model = model;
        this.dailyPrice = dailyPrice;
        this.modelYear = modelYear;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(String dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt =  new Date(System.currentTimeMillis());
    }
}
