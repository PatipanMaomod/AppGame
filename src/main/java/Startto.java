import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startto extends JFrame {

    private JButton button1;
    private JPanel panel;
    private JLabel Label;



    public Startto() {
        setContentPane(panel);
        setTitle("GAME GOOD");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNextWindow();

            }
            private void openNextWindow() {
                // สร้างหน้าต่างถัดไปและทำให้มันมองเห็นได้
                Arina NextPag = new Arina();
                //เปิดหน้า Arana
                NextPag.setVisible(true);
                //ปิดหน่้านี้
                setVisible(false);
            }


        });
    }


    public static void main(String[] args) {
            Startto s = new Startto();

    }
}