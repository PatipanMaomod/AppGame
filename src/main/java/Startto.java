import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startto extends JFrame {

    private JButton button1;
    private JPanel panel;
    private JLabel Label;


    public Startto() {
        setContentPane(panel);
        setTitle("Next Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }


        });
    }


    public static void main(String[] args) {
            Startto s = new Startto();

    }
}