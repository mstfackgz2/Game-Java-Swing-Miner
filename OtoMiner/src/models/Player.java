
package models;

import controller.KeyHandler;
import generator.MapGenerator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import javax.imageio.ImageIO;
import panels.GamePanel;
import tile.TileManager;


public class Player extends Entity {
    
    private int id;
    private String name;
    Random rand = new Random();
    GamePanel gp;
    KeyHandler keyH; 
    
    public final int screenX;
    public final int screenY;
    
    public Player (GamePanel gp,KeyHandler keyH){
        this.gp =gp;
        this.keyH=keyH;
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        
        
        setDeafaultValues();
        getPlayerImage();
    }
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setDeafaultValues(){
        int tryx= rand.nextInt(990)+1;
        int tryy= rand.nextInt(990)+1;
        
        worldX=gp.tileSize *tryx;
        worldY=gp.tileSize *tryy;
        
        speed=124;
        direction = "down";
    }

     public void update(){
         
         if(keyH.upPressed ==true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
             if(keyH.upPressed == true){
                direction = "up";
            }
            else if(keyH.downPressed == true){                
                direction = "down";
            }
            else if(keyH.leftPressed == true){                
                direction = "left";
            }
            else if(keyH.rightPressed == true){                
                direction = "right";
            }
            if(keyH.kpressed){
                worldX=500;
                worldY=500;
                speed = 4;
            }
        
             
        //check tile collision
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        //if collision false plauer can move 
        if (collisionOn == false){
            switch (direction) {
                case "up":worldY -= speed;break;
                case "down":worldY += speed;break;
                case "left":worldX -= speed;break;
                case "right":worldX += speed;break;
            }
        
        }
        
        
             
        spriteCounter++;
        if(spriteCounter >12){
            if(spriteNum ==1){
            spriteNum =2;
            }
            else if(spriteNum ==2){
                spriteNum =1;
            }
            spriteCounter=0;
        }
         }
    
        
    
    }
    
     public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize,gp.tileSize);
         BufferedImage image = null;
         switch (direction) {
             case "up":
                 if(spriteNum ==1) image = up1;
                 if(spriteNum ==2) image = up2;
                 break;
            case "down":
                if(spriteNum ==1) image = down1;
                if(spriteNum ==2) image = down2;
                 break;
            case "left":
                if(spriteNum ==1) image = left1;
                if(spriteNum ==2) image = left2;
                 break;
            case "right":
                if(spriteNum ==1) image = right1;
                if(spriteNum ==2) image = right2;
                 break;
         }
         g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
     }
    
}
