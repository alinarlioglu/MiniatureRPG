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
public class Dragon extends StaticBody{
    
    //the shape of the enemy
    private static final Shape DRAGON = new PolygonShape(0.82f,2.33f, -1.56f,-0.69f, -0.72f,-2.32f, 1.66f,-2.09f, 1.41f,2.28f);
    //the image to be placed within the shape
    private BodyImage dragonImage;

    public Dragon(World w) {
        super(w, DRAGON);
        dragonImage = new BodyImage("image/dragon.png", 10);
        addImage(dragonImage);
    }
    
    
    
}
