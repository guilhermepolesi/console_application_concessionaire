package controller;

import db.DB;
import db.DbException;
import model.Car;

import java.sql.*;

public class CarDaoJDBC implements CarDao {


    private Connection conn;

    public CarDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Car obj) {

        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        try {
             ps = conn.prepareStatement(
                     "INSERT INTO vehicles "
                     + "(model, year_, manufacturer, price) "
                     + "VALUES "
                     + "(?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS);

             ps.setString(1, obj.getModel());
             ps.setInt(2, obj.getYear());
             ps.setString(3, obj.getManufacturer());
             ps.setDouble(4, obj.getPrice());


             int rowsAffected = ps.executeUpdate();

             long id = 0;
             if (rowsAffected > 0) {
                 ResultSet rs = ps.getGeneratedKeys();
                 if (rs.next()) {
                     id = rs.getLong(1);
                     obj.setId(id);
                 }

                 DB.closeResultSet(rs);

                 ps1 = conn.prepareStatement(
                         "INSERT INTO cars"
                                 + "(id, amount_ports) "
                                 + "VALUES "
                                 + "(?, ?)",
                         Statement.RETURN_GENERATED_KEYS);

                 ps1.setLong(1, id);
                 ps1.setInt(2, obj.getAmountPorts());

                 rowsAffected = ps1.executeUpdate();

                 if (rowsAffected > 2) {
                     System.out.println("2 linhas inseridas");
                 }

             }
             else {
                 throw new DbException("Unexpected error! No rows Affected!");
             }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
            DB.closeStatement(ps1);

        }
    }
}

