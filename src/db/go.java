package db;

import componentANDtools.Tools;
import componentANDtools.Tools.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class go {

    private static String url = "";
    private static Connection con;
    public static String DB_NAME = "shop";

    private static void seturl() {
        url = "jdbc:mysql://localhost:3306/shop" + "?useUnicode=true&&characterEncoding=UTF-8";
    }

    private static void setconnection() {
        try {
            seturl();
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " try again !");
        }

    }

    public static boolean checkuser(String name, String pass) {

        try {
            setconnection();

            Statement stmt = con.createStatement();
            String strchek = "select * from users where username='" + name + "' and PASS='" + pass + "'";

            stmt.executeQuery(strchek);
           
            while (stmt.getResultSet().next()) {
                con.close();
                return true;

            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "faildconnection try again !");
        }

        return false;

    }

    public static boolean runstatment(String stat) {

        try {
            setconnection();
            Statement st = con.createStatement();
            st.execute(stat);
            con.close();
            return true;
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "faild exquit try again !");

        }

        return false;

    }
    
    
    public static String getAutonumber(String tablename,String colm){
    
        try {
            setconnection();
            Statement st=con.createStatement();
            String Autonumber="select max("+colm+")+1  as maxm from "
                    +tablename
                    ;
            st.executeQuery(Autonumber);
            String num="";
            while(st.getResultSet().next())
            {
            num=st.getResultSet().getString("maxm");
            }
            con.close();
            if ( num== null || "".equals(num)) {
                return "1";
                
            }else
                return num;
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "faild exquit try again !");
        }
     
        return "0";    
    }
    
    
    
    public static table getDAtaFromSql(String statement){
        Tools t =new Tools();
        try {
         setconnection();
         Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(statement);
            ResultSetMetaData rsmd=rs.getMetaData();//count of coulm
            int c= rsmd.getColumnCount();
            table Table;
            Table = t.new table(c);
            while (rs.next()){
                Object row[]=new Object[c];
                for (int i = 0; i < c; i++) {
                    row[i]=rs.getString(i+1);
                }
                Table.addnewrow(row);
            }
            con.close();
            return Table;
            
            
        
        }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"faild exquit try again !" );
        return t.new table(0);
        }
    
    
    
        
    }
    
    
    public static void fillcombo(String tablename ,String coulmnname,JComboBox combo){
        try {
            setconnection();
            Statement stmt=con.createStatement();
            ResultSet rs;
            String select="select "+coulmnname+" from "+tablename;
            rs=stmt.executeQuery(select);
            rs.last();
            int c=rs.getRow();
            rs.beforeFirst();
            int i=0;
                String values[]=new String[c];
            
            while(rs.next()){
            
                values[i]=rs.getString(i+1);
                i++;
            }
            con.close();
            combo.setModel(new DefaultComboBoxModel(values ));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "faild exquit try again !" );
        }
    
    }
    
    
    public static void filltable(String SeltctORtable,JTable table){
        try{
        setconnection();
        Statement stmt=con.createStatement();
           
        ResultSet rs;
        String part=SeltctORtable.substring(0,7).toLowerCase();
        String statment;
        
        if("select ".equals(part)){
           rs=stmt.executeQuery(SeltctORtable);
        }else{
        statment="select * from "+SeltctORtable;
        rs=stmt.executeQuery(statment);
        }
        ResultSetMetaData rsmd=rs.getMetaData();
        int c=rsmd.getColumnCount();
            DefaultTableModel modle=( DefaultTableModel) table.getModel();
            Vector row;
            row = new  Vector();
            
            modle.setRowCount(0);
            while(rs.next()){
                row=new Vector(c);
                for (int i = 1; i <= c; i++) {
                    row.add(rs.getString(i));
                }
                modle.addRow(row);
            }
            if(table.getColumnCount()!=c)
                JOptionPane.showMessageDialog(null, "jtable colmns count not eqle to query count\n jtable coulmns count is : "+table.getColumnCount()+"\n qury columns count is :"+c);
             con.close();
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "faild exquit try again -_-!" );
        }
    
    }
    

}
