
package Entyty;

import db.go;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class product implements MainData{
    private int id_product;
    private String kind;
    private String discribe;
    private int number;
    private double price;
    private String comment;
    private double real_price;

  

    @Override
    public void add() {
     String query="insert into product values("
                + id_product 
                +",'" +kind+"'" 
                +",'"+ discribe+"'"
                +",'"+ number+"'"
                +",'"+ price+"'"
                +" ,'" +comment+"','"+
             real_price
                +"')";

        
        boolean isAdd=db.go.runstatment(query);
        if(isAdd){
//               JOptionPane.showMessageDialog(null, "done");
        }else{
            JOptionPane.showMessageDialog(null, "هناك خطاء في ادخال البينات");
         
        }
    }

    @Override
    public void delete(int id) {
     String query="DELETE FROM `product` WHERE `product`.`id_product`= "+id+";"


                 ;  
        
        boolean isdelete=db.go.runstatment(query);
        if(isdelete){
               JOptionPane.showMessageDialog(null, "done");
        }else{
            JOptionPane.showMessageDialog(null, "faild");
         
        }   
    }

    @Override
    public void update(int id) {
     String query="update product set "+
                 "kind ='"+kind+"',"+
                "discribe='"+discribe+"',"+
                "number='"+number+"',"+
                "price='"+price+"',"+
                
                 "comment='"+comment+"', "+
                 "real_pricre="+real_price+
                 
                 "where id_product = "+id;
        
        boolean isupdate=db.go.runstatment(query);
        if(isupdate){
               JOptionPane.showMessageDialog(null, "done");
        }else{
            JOptionPane.showMessageDialog(null, "faild");
         
        }  
    }

    @Override
    public String autonumbers() {
         return db.go.getAutonumber("product", "id_PRODUCT");
    }

    @Override
    public void getallrows(JTable table) {
        db.go.filltable("product", table);
    }

    @Override
    public void getonerow(JTable table) {
         String query="select * from product where id_product ="+id_product;
        db.go.filltable(query, table);
       }

    @Override
    public void getCustomrow(String statement, JTable table) {
         db.go.filltable(statement, table);
    }

    @Override
    public String getvaluebyname(String name) {
          String query="select id_product from product where discribe = '"+name+"'";
         String val;
        val = (String)db.go.getDAtaFromSql(query).item[0][0];
         return val;
      }

    @Override
    public String getnamebyvalue(String value) {
         String query="select kind,discribe from product where id_product = '"+value+"'";
         String val;
        val = (String)db.go.getDAtaFromSql(query).item[0][0];
         return val;
       
      }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getReal_price() {
        return real_price;
    }

    public void setReal_price(double real_price) {
        this.real_price = real_price;
    }

   

    public void addproduct(int idd, int number) {
       String query="update product SET NUMBER=NUMBER+"+number+" WHERE id_product="+idd;
       go.runstatment(query);
    
    }

   
    
}
