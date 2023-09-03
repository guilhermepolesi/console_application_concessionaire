package model.services;

import model.Car;
import model.dao.CarDao;
import model.dao.DaoFactory;

import java.util.List;

public class CarService {

    private CarDao carDao = DaoFactory.createCarDao();

    public void save(Car obj) {
        if (obj.getId() == null) {
            carDao.insert(obj);
        }
    }

    public Car findById(Long id) {
        return carDao.findById(id);
    }

    public List<Car> findAll() {
        return carDao.findAll();
    }

    public void update(Car obj) {
        carDao.update(obj);
    }

    public void remove(Long id) {
        carDao.deleteById(id);
    }

}
