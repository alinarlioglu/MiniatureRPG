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
public class MageBossDrop extends StaticBody{
    //Setting the shape of the sword drop
    private static final Shape SWORD_DROP_SHAPE = new PolygonShape(0.94f,2.16f, -1.39f,-1.66f, -0.41f,-1.99f, 0.41f,-0.61f, 1.01f,2.07f);
    //Putting an image inside the shape
    private BodyImage swordImage = new BodyImage("image/bossdrop.png", 4);

    public MageBossDrop(World w) {
        super(w, SWORD_DROP_SHAPE);
        addImage(swordImage);
    }
    
}
