
package models.obstacle;

import models.Location;


public class Obstacle {

    public Location flagPoint;
    public int sizeX =0;
    public int sizeY =0;
    public int id=0;

    public Obstacle(Location flagPoint,int x ,int y) {
        this.flagPoint = flagPoint;
        this.sizeX = x;
        this.sizeY = y;
    }
    
        public Obstacle(Location flagPoint) {
        this.flagPoint = flagPoint;

    }

}
