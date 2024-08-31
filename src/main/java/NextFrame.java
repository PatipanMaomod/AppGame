import javax.swing.*;

public class NextFrame extends JFrame {

    public NextFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Next Frame");

        // ตั้งค่า Layout และเพิ่มคอมโพเนนต์
        setLayout(new java.awt.FlowLayout());
        add(new JLabel("This is the next window"));

        pack();
        setLocationRelativeTo(null); // ตั้งค่าให้หน้าต่างอยู่ตรงกลางของหน้าจอ
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NextFrame().setVisible(true));
    }
}