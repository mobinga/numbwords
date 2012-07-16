package numbwords;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui {

  static JFrame jf;
  static JLabel jl;
  static JLabel jl2;
  static JTextField jtf;
  static JPanel jp;
  static core core = new core();

    public gui(){
        jf = new JFrame("NumbWords");
        jl = new JLabel("Input Number: [0-999,999]");
        jl2 = new JLabel();
        jtf = new JTextField();
        jp = new JPanel(null);

        jl.setSize(200, 25);
        jl.setLocation(25, 15);

        jl2.setSize(900, 25);
        jl2.setLocation(25, 65);

        jtf.setSize(550,25);
        jtf.setLocation(25, 40);

        jp.add(jl);
        jp.add(jl2);
        jp.add(jtf);

        jf.add(jp);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setSize(600, 150);
        jf.setLocation(50, 50);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws InterruptedException {
        gui o = new gui();

        jtf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jl2.setText( core.parse(jtf.getText()) + "." );
            }
            
        });


    }

}
