package model.dao;

import model.Car;

import java.util.List;

public interface CarDao {

    void insert(Car obj);
    Car findById(Long id);
    List<Car> findAll();
    void update(Car obj);
    void deleteById(Long id);


}
