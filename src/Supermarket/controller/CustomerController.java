/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer.controller;
import java.sql.Connection;
import item.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import Customer.model.CustomerModel;
/**
 *
 * @author A-Z Electronic
 */
public class CustomerController {
    public String saveCustomer (CustomerModel customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, customer.getId());
        preparedstatement.setString(2, customer.getTitle());
        preparedstatement.setString(3, customer.getFirstName());
        preparedstatement.setString(4, customer.getLastName());
        preparedstatement.setString(5, customer.getAddress());
        preparedstatement.setString(6, customer.getZipcode());
        preparedstatement.setInt(7, customer.getAge()); 
        preparedstatement.setString(8, customer.getMobile());
        preparedstatement.setString(9, customer.getGender());
           
        
        if(preparedstatement.executeUpdate()>0){
            return "Sucess";
            
        }else{return "Failed";
}
    }