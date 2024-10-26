/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.obstacle.dynamicObstacles;

import models.Location;
import models.obstacle.DynamicObstacle;

/**
 *
 * @author musta
 */
public class Bee extends DynamicObstacle {
    int beeSize = 2;
    int pathSize =3;
    
        public Bee( Location flagPoint) {
            super(flagPoint);
            sizeX = beeSize;
            sizeY = beeSize;
            this.direction = "left-right";
            id = 2;
    }
    
}
