import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    JLabel label = new JLabel();
    static final int SCREEN_W = 600;
    static final int SCREEN_H = 600;
    static final int SINGLE_UNIT = 20;
    static final int GAME_BOARD = (SCREEN_W*SCREEN_H)/SINGLE_UNIT;
    int[][] gameArea = new int[GAME_BOARD][GAME_BOARD];
    static final int DELAY = 100;
    final int[] x = new int[GAME_BOARD];
    final int[] y = new int[GAME_BOARD];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'D';
    boolean isRunning = false;
    boolean drawGrid = true;
    Timer timer;
    Random random;

    Panel(){
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_W,SCREEN_H));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new MyKeyAdpater());
        startGame();
    }

    public void startGame(){
        spawnApple();
        isRunning = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if (drawGrid) {
            for (int i = 0; i < SCREEN_H / SINGLE_UNIT; i++) {
                g.setColor(Color.darkGray);
                g.drawLine(0, i * SINGLE_UNIT, SCREEN_W, i * SINGLE_UNIT);
                g.drawLine(i * SINGLE_UNIT, 0, i * SINGLE_UNIT, SCREEN_H);
            }
        }
        g.setColor(Color.RED);
        g.fillOval(appleX,appleY,SINGLE_UNIT,SINGLE_UNIT);
        for(int i = 0; i< bodyParts;i++) {
            if(i == 0) {
                g.setColor(Color.green);
                g.fillRect(x[i], y[i], SINGLE_UNIT, SINGLE_UNIT);
            }
            else {
                g.setColor(new Color(59, 89, 49));
                //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                g.fillRect(x[i], y[i], SINGLE_UNIT, SINGLE_UNIT);
            }
        }
    }
    public void spawnApple() {
        appleX = random.nextInt((SCREEN_W / SINGLE_UNIT)) * SINGLE_UNIT;
        appleY = random.nextInt((SCREEN_H / SINGLE_UNIT)) * SINGLE_UNIT;
    }
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - SINGLE_UNIT;
                break;
            case 'D':
                y[0] = y[0] + SINGLE_UNIT;
                break;
            case 'L':
                x[0] = x[0] - SINGLE_UNIT;
                break;
            case 'R':
                x[0] = x[0] + SINGLE_UNIT;
                break;
        }
            

    }
    public  void checkApple(){

    }
    public void checkCollision(){

    }
    public void gameOver(Graphics g){

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning){
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

    public class MyKeyAdpater extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}
