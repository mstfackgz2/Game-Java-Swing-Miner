/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.obstacle.staticObstacles;

import java.util.Random;
import models.Location;
import models.obstacle.StaticObstacle;

/**
 *
 * @author musta
 */
public class Wall extends StaticObstacle{

        public Wall(Location flagPoint) {
        super(flagPoint);
        sizeX = 10;
        sizeY = 1;
        id = 7;
    }
    
}
