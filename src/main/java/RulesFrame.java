import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesFrame extends JFrame {
    private JButton buttonnext;
    private JPanel RulesPanel;
    private JLabel Ruleslabel;
    private JLabel detalelabel;
    private JButton buttonbtstart;

    public RulesFrame() {
        setTitle("Rules");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        buttonnext = new JButton("Next");

        setLayout(new FlowLayout());
        add(buttonnext);


        buttonnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
    }
    private void next() {
        ModeFrame MF = new ModFrame();
        MF.setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        new RulesFrame();

    }
}
