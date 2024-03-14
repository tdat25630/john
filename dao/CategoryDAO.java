/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

//import entity.Product;
import entity.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author admin
 */
public class CategoryDAO extends MyDAO{
    
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<Category>();
        xSql = "select * from Category";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      int id; 
      String name; 
      
      Category c ;
      while(rs.next()){
          id = rs.getInt("cid");
          name = rs.getString("cname");
         
          c = new Category(id, name);
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
//        CategoryDAO dao = new CategoryDAO();
//        List<Category> list = dao.getAllCategory();
//        for (Category x : list) {
//            System.out.println(x);
//        }
//    }
}
    

