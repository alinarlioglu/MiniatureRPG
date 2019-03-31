/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author Ali
 */
public class DragonFightingStance extends StaticBody {
    //setting the shape of the fire dragon
    private static final Shape FIRE_DRAGON = new PolygonShape(2.29f,2.41f, -1.57f,1.28f, -2.81f,-1.03f, -0.98f,-2.25f, 1.1f,-2.18f, 2.87f,-1.22f, 2.92f,0.07f, 2.75f,1.24f);
    //the image to be placed on the fire dragon
    private BodyImage fireDragon;

    public DragonFightingStance(World w) {
        super(w, FIRE_DRAGON);
        fireDragon = new BodyImage("image/firedragon.png", 10);
        addImage(fireDragon);
    }
    
    
}
