package model.services;

import model.Car;
import model.Motorcycle;
import model.dao.CarDao;
import model.dao.DaoFactory;
import model.dao.MotorcycleDao;

import java.util.List;

public class MotorcycleService {

    private MotorcycleDao motorcycleDao = DaoFactory.createMotorcycleDao();

    public void save(Motorcycle obj) {
        if (obj.getId() == null) {
            motorcycleDao.insert(obj);
        }
    }

    public Motorcycle findById(Long id) {
        return motorcycleDao.findById(id);
    }

    public List<Motorcycle> findAll() {
        return motorcycleDao.findAll();
    }

    public void update(Motorcycle obj) {
        motorcycleDao.update(obj);
    }

    public void remove(Long id) {
        motorcycleDao.deleteById(id);
    }

}
