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
//The quest mob.
public class Cat extends StaticBody{
    
    //The shape of the cat enemy.
    private static final Shape CAT_SHAPE = new PolygonShape(-0.36f,0.46f, -0.15f,-0.485f, 0.245f,-0.465f, 0.25f,0.285f, 0.195f,0.485f, -0.315f,0.47f);
    //The 'cat' image to be placed on the mob.
    private BodyImage catImage;
    
    public Cat(World w) {
        super(w, CAT_SHAPE);
        catImage = new BodyImage("image/pokemon.gif", 3.5f);
        addImage(catImage);
    }
    
}
