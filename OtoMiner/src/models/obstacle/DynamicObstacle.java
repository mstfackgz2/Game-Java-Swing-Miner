package models.obstacle;

import models.Location;

public class DynamicObstacle extends Obstacle {
    public int pathSize = 0;
    public String direction;

    public DynamicObstacle( Location flagPoint) {
        super(flagPoint);

    }

}
