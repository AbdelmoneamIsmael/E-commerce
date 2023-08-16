
package Entyty;

import db.go;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class customers implements MainData{
    private int id;
    private int id_product;
    private int id_person;
    private String name;
    private double one_Price;
    private String ft;
    private String discribe;
    private String kind;
    private String date_of_begain;
    private int allPeriod;
    private int last_price;
    private int remainder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOne_Price() {
        return one_Price;
    }

    public void setOne_Price(double one_Price) {
        this.one_Price = one_Price;
    }

    public String getFt() {
        return ft;
    }

    public void setFt(String ft) {
        this.ft = ft;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDate_of_begain() {
        return date_of_begain;
    }

    public void setDate_of_begain(String date_of_begain) {
        this.date_of_begain = date_of_begain;
    }

    public int getAllPeriod() {
        return allPeriod;
    }

    public void setAllPeriod(int allPeriod) {
        this.allPeriod = allPeriod;
    }

    public int getLast_price() {
        return last_price;
    }

    public void setLast_price(int last_price) {
        this.last_price = last_price;
    }

    @Override
    public void add() {
          String query="INSERT INTO `customer` (`id`, `id_person`, `id_product`, `date_begain`, `periode`, `Oprice`, `LPRICE`, `remainder`) "
                  + "VALUES "
                  + "('"+id+"', '"+id_person+"', '"+id_product+"', '"+date_of_begain+"', '"+allPeriod+"', '"+one_Price+"', '"+last_price+"', '"+remainder+"');";
         if(! db.go.runstatment(query)){
             JOptionPane.showMessageDialog(null, "هناك خطاء في ادخال البينات راجع مدخلاتك");
         }
    }

    @Override
    public void delete(int id) {
        
         String query ="DELETE FROM `customer` WHERE `customer`.`id` = " +id;
        
         go.runstatment(query);
        
        
        
        
        
        
       }

    @Override
    public void update(int id) {
        }

    @Override
    public String autonumbers() {
        return null;
       }

    @Override
    public void getallrows(JTable table) {
        String quiry="select * from customer_dataa" ;
        db.go.filltable(quiry, table);
       }

    @Override
   public void getonerow(JTable table) {
    }

    @Override
    public void getCustomrow(String statement, JTable table) {
         db.go.filltable(statement, table);
       
       
      }
    
    public void getallbyid(int idd,JTable table){
     String query = "select * FROM customer_dataa WHERE `customer_dataa`.`id_person` = " + idd;
               

        db.go.filltable(query, table);
    
    }

    @Override
    public String getvaluebyname(String name) {
        return null;
     }

    @Override
    public String getnamebyvalue(String value) {
        return null;
       
    
    }
    public static boolean isEmpty(JTable jTable) {
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0;
        }
        return false;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }
    
}
