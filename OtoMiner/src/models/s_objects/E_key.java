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
public class E_key extends SuperObject{
    public E_key() {
        id =10;
        name = "emerald-key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/e_key.png")); 
        } catch (Exception e) {
        }
    
    }
}
