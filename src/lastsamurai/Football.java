/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;

/**
 *
 * @author Ali
 */
public class Football extends StaticBody{
    
    //the shape of the enemy
    private static final Shape circle = new CircleShape(1.0f);
    //the image to be placed within the circle shape
    private BodyImage football;
    
    public Football(GameWorld w) {
        super(w, circle);
        football = new BodyImage("image/football.png", 3);
        addImage(football);
    }
    
    
    
}
