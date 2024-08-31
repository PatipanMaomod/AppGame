import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AranaFrame extends JFrame {

    private JButton button1;
    private JPanel panel1;

    public AranaFrame() {
        setTitle("Next Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);



        button1 = new JButton("Back");

        // ตั้งค่า Layout และเพิ่มปุ่ม Button
        setLayout(new java.awt.FlowLayout());
        add(button1);

        // สร้างและเพิ่มคอมโพเนนต์อื่นๆ ที่ต้องการใน NextWindow

        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNextWindow();
            }

            private void openNextWindow() {
                // สร้างหน้าต่างถัดไปและทำให้มันมองเห็นได้
                MainGUI MG = new MainGUI();
                //เปิดหน้า Arana
                MG.setVisible(true);
                //ปิดหน่้านี้
                setVisible(false);
            }

        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AranaFrame());
    }
}
