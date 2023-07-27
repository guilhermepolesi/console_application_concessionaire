package model.services;

import model.Car;
import model.dao.CarDao;
import model.dao.DaoFactory;

public class CarService {

    private CarDao carDao = DaoFactory.createCarDao();

    public void save(Car obj) {
        if (obj.getId() == null) {
            carDao.insert(obj);
        }
    }

}
