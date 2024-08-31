import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI<NextWindow> extends JFrame {
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
        GOButton = new JButton("Start Game");

        // ตั้งค่า Layout และเพิ่มปุ่ม GOButton
        setLayout(new java.awt.FlowLayout());
        add(GOButton);

        // ตั้งค่า ActionListener ให้กับปุ่ม GOButton
        GOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNextWindow();
            }
        });
        setVisible(true);
    }
    private void openNextWindow() {
        // สร้างหน้าต่างถัดไปและทำให้มันมองเห็นได้
        AranaFrame AF = new AranaFrame();
        //เปิดหน้า Arana
        AF.setVisible(true);
        //ปิดหน่้านี้
        setVisible(false);
    }


    public static void main(String[] args) {
        new MainGUI();
    }

}
