
package Entyty;

import db.go;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class part {
    private int id_product;
    private int period;
    private int first_price;
    private int one_price;
    private int full_price;

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getFirst_price() {
        return first_price;
    }

    public void setFirst_price(int first_price) {
        this.first_price = first_price;
    }

    public int getOne_price() {
        return one_price;
    }

    public void setOne_price(int one_price) {
        this.one_price = one_price;
    }
    
    public void add(int id){
            String quiry="INSERT INTO `part`  VALUES ('"+id+"', '"+period+"', '"+first_price+"', '"+one_price+"','"+full_price+"')";
            go.runstatment(quiry);
            JOptionPane.showMessageDialog(null, "done");
    }
    
    
    public void delete(int id){
            String quiry="DELETE FROM `part` WHERE `part`.`id_product` = "+id;
            go.runstatment(quiry);
            JOptionPane.showMessageDialog(null, "done");
    
    
    }
    
    
    public void update(int id){
            String quiry="UPDATE `part` SET `periode` = '"+period+"', `first_price` = '"+first_price+"', `one_price` = '"+one_price+"' WHERE `part`.`id_product` = "+id;
            go.runstatment(quiry);
            JOptionPane.showMessageDialog(null, "done");
    
    }
    public void fill_table(JTable table,int id){
         String quiry="SELECT * FROM `parts_details` where id_product="+id;
      go.filltable(quiry, table);
    }

    public int getFull_price() {
        return full_price;
    }

    public void setFull_price(int full_price) {
        this.full_price = full_price;
    }

    public void paypart(int idd) {
         String quiry="UPDATE customer SET remainder=remainder-1 WHERE id="+idd;
        if( go.runstatment(quiry))
            JOptionPane.showMessageDialog(null, "Done");
        
        
        
       }
    
    
}
