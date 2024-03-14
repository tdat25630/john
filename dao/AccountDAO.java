/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class AccountDAO extends MyDAO{
    public Account login (String user,String pass){
        xSql = "select * from account where [user] = ? and pass = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
        
       
        while(rs.next()){
          return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5));
          
          
        }
        rs.close();
        ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Account getAccount(String xxName) {
    
    xSql = "select * from account where [user]= ? ";
    
    Account x;
    try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, xxName);
      rs = ps.executeQuery();
      while(rs.next()) {
        return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5));
          
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return null;
  }
    public void signup(String user,String pass) {
     xSql = "insert into account ([user],pass,isSell,isAdmin) values (?,?,0,0)"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, user);
      ps.setString(2, pass);
      
      ps.executeUpdate();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
  }
//    public static void main(String[] args) {
//        AccountDAO u = new AccountDAO();
//        Account test = u.getAccount("Adam");
//        System.out.println(test);
//    }
}
