package model.dao;

import db.DB;
import model.dao.impl.CarDaoJDBC;

public class DaoFactory {

    public static CarDao createCarDao() {
        return new CarDaoJDBC(DB.getConnection());
    }

}
