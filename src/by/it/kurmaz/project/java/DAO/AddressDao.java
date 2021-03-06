package by.it.kurmaz.project.java.DAO;
import by.it.kurmaz.project.java.beans.Address;
import by.it.kurmaz.project.java.connection.dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Locale;

public class AddressDao extends AbstractDAO implements DaoInterface<Address>{


    @Override
    public Address read(long id) throws SQLException {
        List<Address> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Address address) throws SQLException {
        String sql = String.format(Locale.US,"INSERT INTO `address`(`Country`, `City`, `Street`, `Building`, `Apt`, `ZIP`,  `Users_ID`)" +
                        "VALUES ('%s','%s','%s','%s','%s', '%s', %d)",
                address.getCountry(), address.getCity(), address.getStreet(), address.getBuilding(), address.getApt(), address.getZip(), address.getUsers_id());
        long id = executeUpdate(sql);
        if (id > 0) {
            address.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Address address) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `address` SET `Country`='%s', `City`='%s', `Street`='%s', `Building`='%s', `Apt`='%s', ZIP='%s', `Users_ID`='%d' WHERE ID=%d",
                address.getCountry(), address.getCity(), address.getStreet(), address.getBuilding(), address.getApt(), address.getZip(), address.getUsers_id(), address.getId());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public boolean delete(Address address) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `address` WHERE id=%d", address.getId());
        return (executeUpdate(sql) > 0);
    }

    @Override
    public List<Address> getAll(String whereAndOrder) throws SQLException {
        List<Address> addresses = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.US, "" + "SELECT `ID`, `Country`, `City`, `Street`, `Building`, `Apt`, `ZIP`,  `Users_ID` FROM `address` %s", whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Address address = new Address(
                        resultSet.getLong("ID"),
                        resultSet.getString("Country"),
                        resultSet.getString("City"),
                        resultSet.getString("Street"),
                        resultSet.getString("Building"),
                        resultSet.getString("Apt"),
                        resultSet.getString("ZIP"),
                        resultSet.getLong("Users_ID")
                );
                addresses.add(address);
            }
        }
        return addresses;
    }
}
