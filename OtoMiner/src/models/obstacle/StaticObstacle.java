/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.obstacle;

import models.Location;

/**
 *
 * @author musta
 */
public class StaticObstacle extends Obstacle {
    
    public StaticObstacle(Location flagPoint, int x, int y) {
        super(flagPoint, x, y);
    }

    public StaticObstacle(Location flagPoint) {
        super(flagPoint);
    }
    
}
