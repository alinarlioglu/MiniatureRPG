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
public class Sword extends StaticBody {
    //setting the shape for the sword
    private static final Shape SWORD = new PolygonShape(1.95f,2.46f, -1.55f,-0.25f, -2.11f,-2.06f, -0.32f,-1.42f, 2.08f,2.2f);
    //the image to set for the sword shape
    private BodyImage swordImage;

    public Sword(World w) {
        super(w, SWORD);
        
        swordImage = new BodyImage("image/sword.png", 5);
        addImage(swordImage);
    }
    
    
}
