/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicrm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import minicrm.entity.Customer;
import minicrm.entity.Interaction;
import minicrm.entity.Representative;

/**
 *
 * @author ipd
 */
public class Database {

    private Connection conn;

    public Database() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
    }

    public void addRep(String nameFirst, String nameLast) throws SQLException {
        String query = "INSERT INTO Representative VALUES (NULL,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nameFirst);
        ps.setString(2, nameLast);
        ps.execute();
    }

    public ArrayList<Representative> getAllReps() throws SQLException {
        final String query = "SELECT * FROM Representative";
        ArrayList<Representative> result = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("representativeID");
                String nameFirst = rs.getString("nameFirst");
                String nameLast = rs.getString("nameLast");
                Representative r = new Representative(id, nameFirst, nameLast);
                result.add(r);
            }
        }
        return result;
    }

    public void addCustomer(String nameFirst, String nameLast, String address,
            String postalCode, String phoneNumber, String SIN) throws SQLException {
        String query = "INSERT INTO Customer VALUES (NULL,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, nameFirst);
        ps.setString(2, nameLast);
        ps.setString(3, address);
        ps.setString(4, postalCode);
        ps.setString(5, phoneNumber);
        ps.setString(6, SIN);
        ps.execute();
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException {
        final String query = "SELECT * FROM Customer";
        ArrayList<Customer> result = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("customerID");
                String nameFirst = rs.getString("nameFirst");
                String nameLast = rs.getString("nameLast");
                String address = rs.getString("address");
                String postalCode = rs.getString("postalCode");
                String phoneNumber = rs.getString("phoneNumber");
                String SIN = rs.getString("SIN");
                Customer c = new Customer(id, nameFirst, nameLast,
                        address, postalCode, phoneNumber, SIN);
                result.add(c);
            }
        }
        return result;
    }

    public ArrayList<Interaction> getInteractions(String custNameFirst,String custNameLast,
    String repNameFirst,String repNameLast) throws SQLException, SQLExceptionResultEmpty {
        final String query = "SELECT * FROM Interaction as I "
                + "inner join Customer as C"
                + "on I.customerID = C.customerID"
                + "inner join Representative as R"
                + "on I.repID = R.representativeID"
                + "where C.nameFirst = " + custNameFirst
                + "and C.nameLast = " + custNameLast
                + "and R.nameFirst = " + repNameFirst
                + "and R.nameLast = " + repNameLast;
        ArrayList<Interaction> result = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                throw new SQLExceptionResultEmpty();
            }
            int InteractionID = rs.getInt("InteractionID");
            int customerID = rs.getInt("customerID");
            int repID = rs.getInt("repID");
            String date = rs.getString("date");
            String notes = rs.getString("notes");
            Interaction i = new Interaction(InteractionID, customerID, repID, date, notes);
            result.add(i);
        }
        return result;
    }

    private static class SQLExceptionResultEmpty extends Exception {

        public SQLExceptionResultEmpty() {
        }
    }

}
