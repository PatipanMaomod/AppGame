import javax.swing.*;

public class Arina {
    private JButton Button1;
    private JPanel panel;
    public Arina() {
        panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Arina");
        label.setBounds(10, 10, 100, 20);
        panel.add(label);
        Button1 = new JButton("Button1");
        Button1.setBounds(10, 50, 100, 20);
        panel.add(Button1);

    }
}
