package model.dao;

import db.DB;
import model.dao.impl.CarDaoJDBC;
import model.dao.impl.MotorcycleDaoJDBC;

public class DaoFactory {

    public static CarDao createCarDao() {
        return new CarDaoJDBC(DB.getConnection());
    }

    public static MotorcycleDao createMotorcycleDao() {
        return new MotorcycleDaoJDBC(DB.getConnection());
    }

}
