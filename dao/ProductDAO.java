/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Product;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author admin
 */
public class ProductDAO extends MyDAO{
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<Product>();
        xSql = "select * from product";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      int id; 
      String name; 
      String image; 
      double price; 
      String title;
      String description;
      Product p ;
      while(rs.next()){
          id = rs.getInt("id");
          name = rs.getString("name");
          image = rs.getString("image");
          price = rs.getDouble("price");
          title = rs.getString("title");
          description = rs.getString("description");
          p = new Product(id, name, image, price, title, description);
          list.add(p);
      }
       rs.close();
      ps.close();
      
    }catch(Exception e){
        e.printStackTrace();
    }
        
        return (list);
    }
    public Product getNewest(){
        xSql = "select top 1 * from product order by id desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
        int id; 
        String name; 
        String image; 
        double price; 
        String title;
        String description;
        Product p;
        while(rs.next()){
          id = rs.getInt("id");
          name = rs.getString("name");
          image = rs.getString("image");
          price = rs.getDouble("price");
          title = rs.getString("title");
          description = rs.getString("description");
          return new Product(id, name, image, price, title, description);
          
        }
        rs.close();
        ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return p;
        return null;
    }
    public List<Product> getAllProductByCID(int cid){
        List<Product> list = new ArrayList<Product>();
        xSql = "select * from product where cateID = ? ";
    try {
      ps = con.prepareStatement(xSql);
      ps.setInt(1, cid);
      rs = ps.executeQuery();
      
      int id;   
      String name; 
      String image; 
      double price; 
      String title;
      String description;
      Product p ;
      while(rs.next()){
          id = rs.getInt("id");
          name = rs.getString("name");
          image = rs.getString("image");
          price = rs.getDouble("price");
          title = rs.getString("title");
          description = rs.getString("description");
          p = new Product(id, name, image, price, title, description);
          list.add(p);
      }
       rs.close();
      ps.close();
      
    }catch(Exception e){
        e.printStackTrace();
    }
        
        return (list);
    }
    
    public List<Product> getAllProductByName(String xxName){
        List<Product> list = new ArrayList<Product>();
        xSql = "select * from product where name like '%" + xxName + "%'";
    try {
      ps = con.prepareStatement(xSql);
//      ps.setString(1, name);
      rs = ps.executeQuery();
      
      int id;   
      String name; 
      String image; 
      double price; 
      String title;
      String description;
      Product p ;
      while(rs.next()){
          id = rs.getInt("id");
          name = rs.getString("name");
          image = rs.getString("image");
          price = rs.getDouble("price");
          title = rs.getString("title");
          description = rs.getString("description");
          p = new Product(id, name, image, price, title, description);
          list.add(p);
      }
       rs.close();
      ps.close();
      
    }catch(Exception e){
        e.printStackTrace();
    }
        
        return (list);
    }
    public List<Product> getAllProductBySellID(int sid){
        List<Product> list = new ArrayList<Product>();
        xSql = "select * from product where sell_ID = ? ";
    try {
      ps = con.prepareStatement(xSql);
      ps.setInt(1, sid);
      rs = ps.executeQuery();
      
      int id;   
      String name; 
      String image; 
      double price; 
      String title;
      String description;
      Product p ;
      while(rs.next()){
          id = rs.getInt("id");
          name = rs.getString("name");
          image = rs.getString("image");
          price = rs.getDouble("price");
          title = rs.getString("title");
          description = rs.getString("description");
          p = new Product(id, name, image, price, title, description);
          list.add(p);
      }
       rs.close();
      ps.close();
      
    }catch(Exception e){
        e.printStackTrace();
    }
        
        return (list);
    }
    public void deleteProduct(String pid){
        xSql = "delete from product where id = ? ";
        try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, pid);
      ps.executeUpdate();
      
      
      
      rs.close();
      ps.close();
      
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    public void insertProduct( String name, String image, double price, String title, String description, int cate_ID,int sid){
        xSql = "insert into product (name,image,price,title,description,cateID,sell_ID) values (?,?,?,?,?,?,?)"; 
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2 , image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, cate_ID);
            ps.setInt(7, sid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Product getProductByID( int id){
        xSql = "select * from product where id = ? ";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        int cid; 
        String name; 
        String image; 
        double price; 
        String title;
        String description;
        Product p;
        while(rs.next()){
          id = rs.getInt("id");
          name = rs.getString("name");
          image = rs.getString("image");
          price = rs.getDouble("price");
          title = rs.getString("title");
          description = rs.getString("description");
          cid = rs.getInt("cateID");
          return new Product(id, name, image, price, title, description);
          
        }
        rs.close();
        ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return p;
        return null;
    }
    public void updateProduct( String name, String image, double price, String title, String description, int cate_ID,int pid){
        xSql = "update product set [name] = ?, [image] = ?,\n" +
"price = ? , title = ?, [description] = ?, cateID = ? where id = ?"; 
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2 , image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, cate_ID);
            ps.setInt(7, pid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Product p = dao.getProductByID(20);
//        List<Product> list = dao.getAllProductByCID(1);
            System.out.println(p);
        
            
    }
}
