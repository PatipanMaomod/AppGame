import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JButton openNextButton;
    private JButton button1;
    private JPanel panel1;

    public MainFrame() {
        initComponents();
        button1.addActionListener(new ActionListener() {
        });
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Main Frame");

        // สร้างปุ่มและกำหนดการทำงานเมื่อกดปุ่ม
        openNextButton = new JButton("Open Next Window");
        openNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNextWindow();
            }
        });

        // ตั้งค่า Layout และเพิ่มคอมโพเนนต์
        setLayout(new java.awt.FlowLayout());
        add(openNextButton);

        pack();
        setLocationRelativeTo(null); // ตั้งค่าให้หน้าต่างอยู่ตรงกลางของหน้าจอ
    }

    private void openNextWindow() {
        new NextFrame().setVisible(true);
        this.dispose(); // ปิดหน้าต่างปัจจุบัน (ถ้าต้องการ)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}