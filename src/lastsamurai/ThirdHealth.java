/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.CircleShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import java.awt.Color;

/**
 *
 * @author Ali
 */
public class ThirdHealth extends StaticBody{
    
    //only one object in memory - don't create new instance over and over. Cannot be editted.
    private static final Shape CIRCLE = new CircleShape(0.5f);
    //adds health to samurai
    private int healthAdded;
    
    public ThirdHealth(World w) {
        super(w, CIRCLE);
        setFillColor(Color.red);
        healthAdded = 2;
    }
    
    public int getHealthAdded(){
        return healthAdded;
    }
}
