package model.dao.impl;

import db.DB;
import db.DbException;
import model.Car;
import model.Vehicle;
import model.dao.CarDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoJDBC implements CarDao {


    private Connection conn;

    public CarDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Car obj) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
             ps = conn.prepareStatement(
                     "INSERT INTO cars "
                     + "(model, year_, manufacturer, amount_ports, price) "
                     + "VALUES "
                     + "(?, ?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS);

             ps.setString(1, obj.getModel());
             ps.setInt(2, obj.getYear());
             ps.setString(3, obj.getManufacturer());
             ps.setInt(4, obj.getAmountPorts());
             ps.setDouble(5, obj.getPrice());


             int rowsAffected = ps.executeUpdate();

             long id = 0;
             if (rowsAffected > 0) {
                 rs = ps.getGeneratedKeys();
                 if (rs.next()) {
                     id = rs.getLong(1);
                     obj.setId(id);
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
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public Car findById(Long id) {
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    "SELECT c.id, c.model, c.year_, c.manufacturer, c.amount_ports, c.price "
                            + "FROM cars c "
                            + "WHERE c.id = ?");

            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Car obj = instantiateCar(rs);
                return obj;
            }
                return null;
        }
        catch (SQLException e) {
            throw  new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public List<Car> findAll() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM concessionaire.cars;");

            rs = ps.executeQuery();

            List<Car> list = new ArrayList<>();


            while (rs.next()) {

                Car obj = instantiateCar(rs);
                list.add(obj);
            }
            return list;
        }
        catch(SQLException error) {
            throw new DbException(error.getMessage());
        }
        finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }




    @Override
    public void update(Car obj) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "UPDATE cars "
                            + "SET model = ?, year_ = ?, manufacturer = ?, amount_ports = ?, price = ? "
                            + "WHERE id = ?");

            ps.setString(1, obj.getModel());
            ps.setInt(2, obj.getYear());
            ps.setString(3, obj.getManufacturer());
            ps.setInt(4, obj.getAmountPorts());
            ps.setDouble(5, obj.getPrice());
            ps.setLong(6, obj.getId());

            ps.executeUpdate();

        }
        catch (SQLException error) {
            throw new DbException(error.getMessage());
        }
        finally {
            DB.closeStatement(ps);
        }

    }

    @Override
    public void deleteById(Long id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM concessionaire.cars WHERE Id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
        }
        catch (SQLException error) {
            throw new DbException(error.getMessage());
        }
        finally {
            DB.closeStatement(ps);
        }
    }

    private Car instantiateCar(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getLong("id"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year_"));
        car.setManufacturer(rs.getString("manufacturer"));
        car.setPrice(rs.getDouble("price"));
        car.setAmountPorts(rs.getInt("amount_ports"));
        return car;
    }


}

