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
public class Rock extends StaticObstacle {
    Random rand = new Random();

    public Rock(Location flagPoint) {
        super(flagPoint);
        int size = rand.nextInt(2)+2;
        sizeX = size;
        sizeY = size;
        id = 5;
        
    }

    
}
