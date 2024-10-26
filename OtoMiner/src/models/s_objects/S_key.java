/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.s_objects;

import javax.imageio.ImageIO;
import models.SuperObject;

/**
 *
 * @author musta
 */
public class S_key extends SuperObject{
        public S_key() {
        id=9;
        name = "silver-key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/s_key.png")); 
        } catch (Exception e) {
        }
    
    }
}
