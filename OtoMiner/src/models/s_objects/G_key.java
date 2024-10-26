
package models.s_objects;

import javax.imageio.ImageIO;
import models.SuperObject;


public class G_key extends SuperObject {

    public G_key() {
        id =8;
        name = "gold-key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/g_key.png")); 
        } catch (Exception e) {
        }
    
    }
    
    
    
}
