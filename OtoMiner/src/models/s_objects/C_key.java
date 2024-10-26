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
public class C_key extends SuperObject{
    public C_key() {
        id=11;
        name = "c-key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/c_key.png")); 
        } catch (Exception e) {
        }
    
    }
}
