
package controller;

import models.s_objects.E_key;
import models.s_objects.G_key;
import panels.GamePanel;


public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setObject(){
        gp.obj[0] = new G_key();
        gp.obj[1] = new G_key();
        gp.obj[2] = new G_key();
        gp.obj[3] = new G_key();
        gp.obj[4] = new G_key();

        gp.obj[10] = new E_key();
        gp.obj[11] = new E_key();
        gp.obj[12] = new E_key();
        gp.obj[13] = new E_key();
        gp.obj[14] = new E_key();


        
        
        
    }
    
}
