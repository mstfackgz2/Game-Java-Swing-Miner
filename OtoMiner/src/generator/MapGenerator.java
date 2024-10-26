package generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import models.Location;
import models.SuperObject;
import models.obstacle.Obstacle;
import models.obstacle.dynamicObstacles.Bee;
import models.obstacle.dynamicObstacles.Bird;
import models.obstacle.staticObstacles.Mountain;
import models.obstacle.staticObstacles.Rock;
import models.obstacle.staticObstacles.Tree;
import models.obstacle.staticObstacles.Wall;
import models.s_objects.C_key;
import models.s_objects.E_key;
import models.s_objects.G_key;
import models.s_objects.S_key;
import panels.Starter;


public class MapGenerator {

    
    public int sizeX ;
    public int sizeY;
    public static int map[][];
    ArrayList<Obstacle> statics = new ArrayList<>();
    ArrayList<Obstacle> dynamics = new ArrayList<>();
    ArrayList<SuperObject> keys = new ArrayList<>();
    Random rand = new Random();
    Starter starter;
    public MapGenerator(Starter aThis,int x,int y) {
        this.sizeX =x;
        this.sizeY =y;
        map = new int[sizeX][sizeY];
        setMapZeros(sizeX, sizeY);
        this.starter = aThis;
        createAllObstacle();
        writeToTxt("src/res/maps/map.txt");
        aThis.setEnableB();
    }

    public MapGenerator() {
        }
    public int getMapSizeX(){return sizeX;}
    public int getMapSizeY(){return sizeY;}
   private void writeToTxt(String filePath) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                writer.write(map[i][j] + " ");
            }
            writer.write("\n");
        }
        writer.close();
        
    } catch (IOException e) {
        System.out.println("Dosya yazma işleminde bir hata oluştu: " + e.getMessage());
    }
}
   
    public void setMapZeros(int col, int row) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if(i == 0 || i == sizeX-1 || j ==0 ||j == sizeY-1 ) map[i][j] = 7;
                else map[i][j] = 0;
            }
        }
    }

 public void createAllObstacle(){
        Location flagPoint = new Location(0, 0);
        Obstacle bee = new Bee(flagPoint);
        Obstacle bee2 = new Bee(flagPoint);
        Obstacle bird = new Bird(flagPoint);
        Obstacle bird2 = new Bird(flagPoint);
        Obstacle mountain = new Mountain(flagPoint);
        Obstacle mountain2 = new Mountain(flagPoint);
        Obstacle rock = new Rock(flagPoint);
        Obstacle rock2 = new Rock(flagPoint);        
        Obstacle tree = new Tree(flagPoint);
        Obstacle tree2 = new Tree(flagPoint);
        Obstacle wall = new Wall(flagPoint);
        Obstacle wall2 = new Wall(flagPoint);
        
        statics.add(mountain);
        statics.add(mountain2);
        statics.add(rock);
        statics.add(rock2);
        statics.add(tree);
        statics.add(tree2);
        statics.add(wall);
        statics.add(wall2);
        
        dynamics.add(bee);
        dynamics.add(bee2);
        dynamics.add(bird);
        dynamics.add(bird2);
        
        int[] randomObs = new int[8]; 
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            randomObs[i] = rand.nextInt(4) + 4;
        }

        
        for (int i = 0; i < randomObs.length; i++) {
            switch (randomObs[i]) {
                case 4:
                    Obstacle mountain3 = new Mountain(flagPoint);
                    statics.add(mountain3);
                    break;
                case 5:
                    Obstacle rock3 = new Rock(flagPoint);
                    statics.add(rock3);
                    break;
                case 6:
                    Obstacle tree3 = new Tree(flagPoint);
                    statics.add(tree3);
                    break;
                case 7:
                    Obstacle wall3 = new Wall(flagPoint);
                    statics.add(wall3);
                    break;    
                default:
                    throw new AssertionError();
            }
        }
            for (int i = 0; i < 5; i++) {
                SuperObject g1 = new G_key();
                keys.add(g1);
                SuperObject s1 = new S_key();
                keys.add(s1);
                SuperObject e1 = new E_key();
                keys.add(e1);
                SuperObject c1 = new C_key();
                keys.add(c1);
     }
            

            
        
        
        
        putKeys(keys);
        putStatics(statics);
        putDynamics(dynamics);
         
        
    }

    private void putStatics(ArrayList<Obstacle> statics) {
    for (Obstacle obstacle : statics) {
        boolean placed = false;
        while (!placed) {
            int x = rand.nextInt(sizeX);
            int y = rand.nextInt(sizeY);

            if (map[x][y] == 0 && puttable(obstacle, x, y)) {
                Location loc = new Location(x,y);
                obstacle.flagPoint =loc;
                placeObstacle(obstacle, x, y);
                placed = true;
            }
        }
    }
}


    private boolean puttable(Obstacle obstacle, int x, int y) {
        for (int i = 0; i < obstacle.sizeY + 2; i++) {
            for (int j = 0; j < obstacle.sizeX + 2; j++) {
                int newX = x - 1 + j;
                int newY = y - 1 + i;

                if (newX < 0 || newY < 0 || newX >= sizeX || newY >= sizeY) {
                    return false;
                }

                if (map[newX][newY] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void placeObstacle(Obstacle obstacle, int x, int y) {
        for (int i = 0; i < obstacle.sizeY; i++) {
            for (int j = 0; j < obstacle.sizeX; j++) {
                map[x + j][y + i] = obstacle.id;
            }
        }
    }



    private void putDynamics(ArrayList<Obstacle> dynamics) {
        for (Obstacle obstacle : dynamics) {
            boolean placed = false;
            while (!placed) {
                int x = rand.nextInt(sizeX);
                int y = rand.nextInt(sizeY);

                if (map[x][y] == 0 && puttable(obstacle, x, y)) {
                    placeObstacle(obstacle, x, y);
                    placed = true;
                }
            }
        }
    }

    private void putKeys(ArrayList<SuperObject> keys1) {
        for (SuperObject superObject : keys1) {
            boolean placed = false;
            while (!placed) {
                int x = rand.nextInt(sizeX);
                int y = rand.nextInt(sizeY);

                if (map[x][y] == 0 && puttableKey(superObject, x, y)) {
                    placeKey(superObject, x, y);
                    placed = true;
                }
            }
        
        
        
        }
        }

    private boolean puttableKey(SuperObject superObject, int x, int y) {
       if (map[x][y] != 0) {
                    return false;
                }
    return true;
    }

    private void placeKey(SuperObject superObject, int x, int y) {
        map[x][y]=superObject.id;
        }

}
