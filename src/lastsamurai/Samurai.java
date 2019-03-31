/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.Walker;

/**
 *
 * @author Ali
 */
//Done, so the samurai cannot move on its own such as bouncing off an object.
public class Samurai extends Walker {
    
    //So the samurai can be created within the correct world - just a reference to the created GameWorld object within 'LastSamurai' class.
    private GameWorld w;    
    //Only one copy exists within the memory, so tells the computer to not create another copy of the object and also cannot be edited/changed due to 'final'.
    private static final Shape SAMURAI = new PolygonShape(-0.41f,2.37f, -0.79f,1.71f, -0.78f,-0.17f, -0.55f,-2.45f, 0.67f,-2.44f, 0.8f,-0.13f, 0.71f,1.72f, 0.33f,2.39f);
    //Sets an image to be used within the shape
    private static final BodyImage SAMURAI_IMAGE = new BodyImage("image/z.png", 5);
    //Sets the health of the samurai
    public double health;
    //Setting the shape of the sword drop
    private static final Shape SWORD_SHAPE = new PolygonShape(0.94f,2.16f, -1.39f,-1.66f, -0.41f,-1.99f, 0.41f,-0.61f, 1.01f,2.07f);
    //Putting an image inside the shape
    private BodyImage swordImage = new BodyImage("image/bossdrop.png", 4);
    
    public Samurai(GameWorld w) {
        super(w);
        this.w=w;
        SolidFixture samurai = new SolidFixture(this, SAMURAI, 1);
        addImage(SAMURAI_IMAGE);
        health = 10;
    }
    
    public void addSword(){
        SolidFixture sword = new SolidFixture(this, SWORD_SHAPE, 1);
        addImage(swordImage);
    }
    
    public double getHealth() {
        return health;
    }

    public void setHealth(double health){
        this.health=health;
    }
    
    public void addHealth(double add){
        health = health + add;
    }
    
}
