package lastsamurai;


import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali
 */
public class QuestPopUp extends StaticBody{
    
    private static final Shape POP_UP = new PolygonShape(-0.706f,0.419f, -0.724f,-0.433f, 0.683f,-0.462f, 0.718f,0.485f, -0.674f,0.424f);
    //The image which will contain the quest description.
    private BodyImage popUp;
    
    public QuestPopUp(World w){
        super(w, POP_UP);
        
        popUp = new BodyImage("image/wood.png", 11);
        addImage(popUp);
        setPosition(new Vec2(45, -15));
    }
}
