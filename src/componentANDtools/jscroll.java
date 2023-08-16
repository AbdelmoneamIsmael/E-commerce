
package componentANDtools;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JScrollPane;


public class jscroll extends JScrollPane{

    public jscroll() {
        
        setOpaque(false);
        
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.red);
        
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
     @Override
    protected void paintBorder(Graphics g){
        g.setColor(Color.blue);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }

    
}
