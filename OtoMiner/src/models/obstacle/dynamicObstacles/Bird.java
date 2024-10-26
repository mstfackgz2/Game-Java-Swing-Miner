package models.obstacle.dynamicObstacles;

import models.Location;
import models.obstacle.DynamicObstacle;

public class Bird extends DynamicObstacle {
    int birdSize = 2;
    int pathSize = 5;
    public Bird( Location flagPoint) {
        super(flagPoint);
        sizeX = birdSize;
        sizeY = birdSize;
        this.direction = "up-down";
        id = 3;
    }
}
