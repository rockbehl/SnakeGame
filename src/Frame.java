import javax.swing.*;

public class Frame extends JFrame {

    Frame(){

        add(new Panel());
        setTitle("Snake");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

}
