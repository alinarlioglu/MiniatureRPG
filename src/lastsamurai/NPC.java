/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Sensor;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Ali
 */
public class NPC extends StaticBody {
    //The shape of the NPC.
    private Shape npcShape = new PolygonShape(-0.143f,0.471f, -0.47f,-0.466f, 0.333f,-0.469f, 0.448f,0.122f, -0.056f,0.445f);
    //The image to put on the NPC.
    private BodyImage NPCImage;
    //Allows NPC character to detect collisions, but bodies will pass over it.
    private Sensor sensor;
    

    public NPC(World w) {
        super(w);
        //Instantiates the NPC as a sensor body - other bodies can pass through it and collisions are detected as well. 'this' explains to the Sensor that class itself is the body.
        sensor = new Sensor(this, npcShape);
        //Adds an image to the NPC and sets the position of the NPC when the game is run.
        NPCImage = new BodyImage("image/gif.gif", 6);
        addImage(NPCImage);
        setPosition(new Vec2(45, -22));
    }

    public Sensor getSensor(){
        return sensor;
    }
    
}
