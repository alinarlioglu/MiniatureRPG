/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;

/**
 *
 * @author Ali
 */
public class SamuraiFight extends Walker{
    
     //So the samurai can be created within the correct world - just a reference to the created GameWorld object within 'LastSamurai' class.
    private GameWorld w;
    
    //Only one copy exists within the memory, so tells the computer to not create another copy of the object and also cannot be edited/changed due to 'final'.
    private static final Shape SAMURAI = new PolygonShape(-1.51f,2.06f, -2.18f,-0.55f, -1.5f,-2.38f, 2.31f,0.63f, -0.42f,2.25f);
    
    //Sets an image to be used within the shape
    private static final BodyImage SAMURAI_IMAGE = new BodyImage("image/hi2.png", 5);
    
    
    public SamuraiFight(GameWorld w) {
        super(w, SAMURAI);
        this.w=w;
        addImage(SAMURAI_IMAGE);
    }
}
