import javax.swing.*;
import java.io.IOException;

public class Frame extends JFrame {

    Frame() throws IOException {

        add(new Panel());
        setTitle("Snake");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

}
