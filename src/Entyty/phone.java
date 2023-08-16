package Entyty;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class phone implements MainData {

    private int id_person;

    private String phone;
    private String comment;

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void add() {
        String query = "insert into phone values("
                + id_person
                + ",'" + phone + "'"
                + " ,'" + comment
                + "')";

        boolean isAdd = db.go.runstatment(query);
        if (isAdd) {
            // JOptionPane.showMessageDialog(null, "done");
        } else {
            JOptionPane.showMessageDialog(null, "هذا الاسم موجود من قبل");

        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM pHONE WHERE `phone`.`id_person` = " + id
                + " and phone.phone ='" + phone + "'";

        boolean isdelete = db.go.runstatment(query);
        if (isdelete) {
            JOptionPane.showMessageDialog(null, "done");

        } else {
            JOptionPane.showMessageDialog(null, "هذا الاسم قيد الاستخدام");

        }
    }

    public void deleteallbyname(int id) {
        String query = "DELETE FROM pHONE WHERE `phone`.`id_person` = " + id;

        boolean isdelete = db.go.runstatment(query);
        if (isdelete) {
            JOptionPane.showMessageDialog(null, "done");

        } else {
            JOptionPane.showMessageDialog(null, "هذا الاسم قيد الاستخدام");

        }

    }

    public void getallbyid(int id,JTable table) {
        String query = "select phone FROM pHONE WHERE `phone`.`id_person` = " + id;
               

        db.go.filltable(query, table);
        
        
        
    }

    @Override
    public void update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String autonumbers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getallrows(JTable table) {
        
    }

    @Override
    public void getonerow(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustomrow(String statement, JTable table) {
        db.go.filltable(statement, table);
      }

    @Override
    public String getvaluebyname(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getnamebyvalue(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
