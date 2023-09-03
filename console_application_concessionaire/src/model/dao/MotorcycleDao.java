package model.dao;

import model.Car;
import model.Motorcycle;

import java.util.List;

public interface MotorcycleDao {

    void insert(Motorcycle obj);
    Motorcycle findById(Long id);
    List<Motorcycle> findAll();
    void update(Motorcycle obj);
    void deleteById(Long id);

}
