
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.zip.InflaterInputStream;
import javax.imageio.ImageIO;
import panels.GamePanel;


public class TileManager {

    
    GamePanel gp;
    public Tile[] tile ;
    public int mapTileNumber[][];
    public int maps[][];
    
    
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[20];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/res/maps/map.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/c_key.png"));
            tile[11].collision = false;
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/e_key.png"));
            tile[10].collision = false;
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/s_key.png"));
            tile[9].collision = false;
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/g_key.png"));
            tile[8].collision = false;
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));
            tile[7].collision = true;
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));
            tile[6].collision = true;
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/rock.png"));
            tile[5].collision = true;
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/mountain.png"));
            tile[4].collision = true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bird.png"));
            tile[3].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bee.png"));
            tile[2].collision = true;
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    
    }
    
    public void loadMap(String filePath){
    
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row=0;
            while(col<gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                
                while(col<gp.maxWorldCol && row < gp.maxWorldRow){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNumber[col][row] = num;
                    col ++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
                
            }
            br.close();
        } catch (Exception e) {
        }
        
    }
    
    
    
    public void draw(Graphics2D g2){
        int worldCol =0;
        int worldRow =0;

        
        while (worldCol< gp.maxWorldCol && worldRow< gp.maxWorldRow){
            
            int tileNum = mapTileNumber[worldCol][worldRow];
            
            int worldX = gp.tileSize * worldCol;
            int worldY = gp.tileSize * worldRow;
            
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX 
                    && gp.player.worldX+gp.player.screenX>worldX - gp.tileSize
                    && worldY+ gp.tileSize > gp.player.worldY-gp.player.screenY
                    && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
               g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null); 
            }
            
            
            worldCol++;
            
            if (worldCol == gp.maxWorldCol){
                worldCol=0;
                worldRow++;
                
            }
            
        }
         
    }
    
    
    
}
