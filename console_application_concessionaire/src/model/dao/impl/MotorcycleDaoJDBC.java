package model.dao.impl;

import db.DB;
import db.DbException;
import model.Motorcycle;
import model.dao.MotorcycleDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotorcycleDaoJDBC implements MotorcycleDao {

    private Connection conn;

    public MotorcycleDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Motorcycle obj) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    "INSERT INTO concessionaire.motorcycles "
                            + "(model, year_, manufacturer, engineCapacity, price) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, obj.getModel());
            ps.setInt(2, obj.getYear());
            ps.setString(3, obj.getManufacturer());
            ps.setInt(4, obj.getEngineCapacity());
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
    public Motorcycle findById(Long id) {
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    "SELECT m.id, m.model, m.year_, m.manufacturer, m.engineCapacity, m.price "
                            + "FROM concessionaire.motorcycles m "
                            + "WHERE m.id = ?");

            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Motorcycle obj = instantiateMotorcycle(rs);
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
    public List<Motorcycle> findAll() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM concessionaire.motorcycles;");

            rs = ps.executeQuery();

            List<Motorcycle> list = new ArrayList<>();


            while (rs.next()) {

                Motorcycle obj = instantiateMotorcycle(rs);
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
    public void update(Motorcycle obj) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "UPDATE concessionaire.motorcycles "
                            + "SET model = ?, year_ = ?, manufacturer = ?, engineCapacity = ?, price = ? "
                            + "WHERE id = ?");

            ps.setString(1, obj.getModel());
            ps.setInt(2, obj.getYear());
            ps.setString(3, obj.getManufacturer());
            ps.setInt(4, obj.getEngineCapacity());
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
            ps = conn.prepareStatement("DELETE FROM concessionaire.motorcycles WHERE Id = ?");
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

    private Motorcycle instantiateMotorcycle(ResultSet rs) throws SQLException {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setId(rs.getLong("id"));
        motorcycle.setModel(rs.getString("model"));
        motorcycle.setYear(rs.getInt("year_"));
        motorcycle.setManufacturer(rs.getString("manufacturer"));
        motorcycle.setEngineCapacity(rs.getInt("engineCapacity"));
        motorcycle.setPrice(rs.getDouble("price"));
        return motorcycle;
    }

}
