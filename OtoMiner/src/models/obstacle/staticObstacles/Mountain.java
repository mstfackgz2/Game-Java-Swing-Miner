/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.obstacle.staticObstacles;

import models.Location;
import models.obstacle.StaticObstacle;

/**
 *
 * @author musta
 */
public class Mountain extends StaticObstacle{
    
    public Mountain(Location flagPoint) {
        super(flagPoint);
        sizeX = 15;
        sizeY = 15;
        id = 4;
        
    }
    
}
