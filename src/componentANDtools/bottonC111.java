
package componentANDtools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class bottonC111 extends JButton{

    public bottonC111() {
        
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(new Color(153,51,0));
        setBackground(Color.green);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.white);
        
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
     @Override
    protected void paintBorder(Graphics g){
        g.setColor(new Color(153,51,0));
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }

    
}
