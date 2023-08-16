
package Entyty;

import javax.swing.JTable;


public interface MainData {
    
    public void add();
    
    public void delete(int id);
    
    public void update(int id);
    
    public String autonumbers();
    
    public void getallrows(JTable table); 
    
    public void getonerow(JTable table);
    
    public void getCustomrow(String statement ,JTable table);
    
    public String getvaluebyname(String name);
    
     public String getnamebyvalue(String value);
     
    
    
    
    
    
    
}
