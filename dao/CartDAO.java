/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Cart;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import dao.*;
/**
 *
 * @author admin
 */
public class CartDAO extends MyDAO{
    
    public void insertProductToCart( int aid, int pid, int amount){
        xSql = "insert into Cart (AccountID,ProductID,Amount) values (?,?,?)"; 
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, aid);
            ps.setInt(2 , pid);
            ps.setInt(3, amount);
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Cart> getAllOrderbyAID(int aid){
        List<Cart> list = new ArrayList<Cart>();
        xSql = "select * from Cart where AccountID = ? ";
    try {
      ps = con.prepareStatement(xSql);
      ps.setInt(1, aid);
      rs = ps.executeQuery();
      
      int accid;   
      int pid; 
      int amount; 
      
      Cart c ;
      while(rs.next()){
          accid = rs.getInt("AccountID");
          pid = rs.getInt("ProductID");
          amount = rs.getInt("Amount");
          
          c = new Cart(aid, pid, amount);
          list.add(c);
      }
       rs.close();
      ps.close();
      
    }catch(Exception e){
        e.printStackTrace();
    }
        
        return (list);
    }
    
//    public static void main(String[] args) {
//        AccountDAO u = new AccountDAO();
//        Account test = u.getAccount("Adam");
//        System.out.println(test);
//    }
}
