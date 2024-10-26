
package panels;

import controller.AssetSetter;
import controller.CollisionChecker;
import controller.KeyHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import models.Player;
import models.SuperObject;
import tile.TileManager;


public class GamePanel extends JPanel  implements Runnable{
    
    public final int originalTileSize = 16; //karakterimizin boyutu
    public final int scale =3; //boyutunu ayarlamak icin
    
    public final int tileSize = originalTileSize * scale;
    
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 16;
    
    public final int screenWidth = maxScreenCol *tileSize;
    public final int screenHeight = maxScreenRow *tileSize;
    
    public TileManager tileM = new TileManager(this);
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    public CollisionChecker cChecker  =  new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[20];
    
    
    
    
    
    //world settings 
    public final int  maxWorldCol =1000;
    public final int  maxWorldRow =1000;
    public final int  worldWidth =tileSize * maxScreenCol;
    public final int  worldHeigh =tileSize * maxScreenRow;
    
    

    
    int FPS = 60;
    
    
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
    }
    
    
    public void startGameThread(){
    
        gameThread = new Thread(this);
        gameThread.start();
    
    }
    
    

    @Override
    /*public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        

        while (gameThread != null) {   
           
            update();
            repaint();
            try {             
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if (remainingTime<0){
                    remainingTime =0;
                }
              
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }*/
    public void run(){
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        

        while (gameThread != null) {   
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1){
                update();
                repaint();
                delta-- ;
            }
            
            
        
        }
    
    
    }
    
    
    
    
    
    public void update(){
        player.update();

    }
    
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
        
    
    }
    
    
    
}
