import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JPanel Tpost;
    private JLabel jsMain;
    private JButton GOButton;

    public MainGUI() {
        setTitle("Main GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // สร้างปุ่ม GOButton และกำหนดข้อความ
        GOButton = new JButton("GO");

        // ตั้งค่า Layout และเพิ่มปุ่ม GOButton
        setLayout(new java.awt.FlowLayout());
        add(GOButton);

        GOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }

}
