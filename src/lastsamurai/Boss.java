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
import city.cs.engine.World;

/**
 *
 * @author Ali
 */
public class Boss extends Walker{
    
    private static final Shape BOSS = new PolygonShape(-0.12f,2.42f, -1.81f,0.9f, -1.47f,-1.9f, 1.4f,-1.9f, 1.74f,0.81f, 0.55f,2.48f);
    private BodyImage bossImage;

    public Boss(World world) {
        super(world, BOSS);
        bossImage = new BodyImage("image/mage.png", 3.5f);
        addImage(bossImage);
    }
    
}
