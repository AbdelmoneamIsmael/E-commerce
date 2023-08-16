package Entyty;

import javax.swing.JOptionPane;
import javax.swing.JTable;


public class person implements MainData{
    private int id_person;
    private String name;
    private String adress;
    private String comment;
    private String status;
    



    @Override
    public void add() {
        String query="insert into persone values("
                + id_person 
                +",'" +name+"'" 
                +",'"+ adress+"'"
                +" ,'" +comment
                +"')";

        
        boolean isAdd=db.go.runstatment(query);
        query="INSERT INTO `status` (`id_person`, `state`) VALUES ('"+id_person+"', '"+status+"')";
        db.go.runstatment(query);
        if(isAdd){
//               JOptionPane.showMessageDialog(null, "done");
        }else{
            JOptionPane.showMessageDialog(null, "هذا id موجود من قبل");
         
        }
    }

    @Override
    public void delete(int id) {
         String query="DELETE FROM persone WHERE `persone`.`id_person` = "+id+";"


                 ;  
        
        boolean isdelete=db.go.runstatment(query);
        if(isdelete){
               JOptionPane.showMessageDialog(null, "done");
        }else{
            JOptionPane.showMessageDialog(null, "هذا الاسم قيد الاستخدام داخل البرنامج");
         
        }
        
     }

    
    
    
    @Override
    public void update(int id) {
         String query="update persone set "+
                 "Name ='"+name+"',"+
                "adress='"+adress+"',"+
                 "comment='"+comment+"' "+
                 
                 "where id_person = "+id;
        
        boolean isupdate=db.go.runstatment(query);
        if(isupdate){
//               JOptionPane.showMessageDialog(null, "done");
        }else{
            JOptionPane.showMessageDialog(null, "هذا الاسم قيد الاستخدام في البرنامج /n تعديلة قد يشكل خطرا");
         
        }
       }

    
    
    
    @Override
    public String autonumbers() {
        return db.go.getAutonumber("persone", "id_person");
       }

    @Override
    public void getallrows(JTable table) {
        db.go.filltable("persone", table);
       }

    @Override
    public void getonerow(JTable table) {
        String query="select * from person where id_person ="+id_person;
        db.go.filltable(query, table);
       }

    @Override
    public void getCustomrow(String statement, JTable table) {
        db.go.filltable(statement, table);
       }

    @Override
    public String getvaluebyname(String name) {
        String query="select id_person from persone where name = '"+name+"'";
         String val;
        val = (String)db.go.getDAtaFromSql(query).item[0][0];
         return val;
       }

    @Override
    public String getnamebyvalue(String value) {
         String query="select name from persone where id_person = '"+value+"'";
         String val;
        val = (String)db.go.getDAtaFromSql(query).item[0][0];
         return val;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
