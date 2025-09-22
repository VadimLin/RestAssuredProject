package org.senla.eu.database.dao;

import org.senla.eu.database.entity.Applicant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApplicantDAOImpl implements ApplicantDao {
    private Connection connection;
    public ApplicantDAOImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Optional<Applicant> get(long id) {
        String sql = "SELECT * FROM reg_office.applicants WHERE applicantid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(Applicant.builder()
                        .applicantId(rs.getInt("applicantid"))
                        .surname(rs.getString("surname"))
                        .name(rs.getString("name"))
                        .middleName(rs.getString("middleName"))
                        .passportNumber(rs.getString("passportNumber"))
                        .phoneNumber(rs.getString("phoneNumber"))
                        .registrationAddress(rs.getString("registration_address"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }


   @Override
    public List<Applicant> getAll() {
        List<Applicant> list = new ArrayList<>();
        String sql = "SELECT * FROM reg_office.applicants";
        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Applicant(
                        rs.getInt("applicantid"),
                        rs.getString("surname"),
                        rs.getString("name"),
                        rs.getString("middlename"),
                        rs.getString("passportnumber"),
                        rs.getString("phonenumber"),
                        rs.getString("registration_address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return list;
   }

    @Override
    public void save(Applicant applicant) {
        final int firstIndex = 1;
        final int secondIndex = 2;
        final int thirdIndex = 3;
        final int fourthIndex = 4;
        final int fifthIndex = 5;
        final int sixthIndex = 6;
        String sql = "INSERT INTO reg_office.applicants (surname, name, middlename, passportnumber, phonenumber, registration_address) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(firstIndex, applicant.getSurname());
            stmt.setString(secondIndex, applicant.getName());
            stmt.setString(thirdIndex, applicant.getMiddleName());
            stmt.setString(fourthIndex, applicant.getPassportNumber());
            stmt.setString(fifthIndex, applicant.getPhoneNumber());
            stmt.setString(sixthIndex, applicant.getRegistrationAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
//    @Override
//    public void update(Object o, String[] params) {
//
//    }
//
//    @Override
//    public void delete(Object o) {
//
//    }
}
