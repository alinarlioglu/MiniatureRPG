/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Ali
 */
public class KeyController extends KeyAdapter{
    //Visible reference to the initiated objects
    MyView view;
    JFrame frame;
    LastSamurai ls;
    //x and y positions of the fighting stance body in the world
    private float fightPositionX;
    private float fightPositionY;
    //x and y positions of the samurai in the world
    private float samuraiPositionX;
    private float samuraiPositionY;
    //declares the fighting stance of the samurai
    private SamuraiFight fightStance;
    //declares the samurai character
    private Samurai samurai;
    //setting the pace which the samurai will move y-coordinates/pixels
    private static final float JUMPING_SPEED = 10;
    // setting the pace which the samurai will move x-coordinates/pixels
    private static final float WALKING_SPEED = 4;
    //A reference to the world this class will act on
    private GameWorld w;
    //declaring the collision instance
    private Collision collision;
    //Declares a boolean variable
    private boolean isFightingStanceMoved;

    public KeyController(GameWorld w, MyView view, JFrame frame, LastSamurai ls) {
        this.w=w;
        this.ls=ls;
        this.view=view;
        this.frame=frame;
        
        //initiating the samurai, the fighting stance of the samurai, the collision and the world movement.
        samurai = new Samurai(w);
        fightStance = new SamuraiFight(w);
        collision = new Collision(w.getFootball(), w.getDragon(), samurai, w.getHealth(), ls, w.getSword(), ls.getWorld().getBoss(), ls.getWorld().getHealthTwo(), ls.getWorld().getHealthThree(), ls.getWorld().getCat(), ls.getWorld().getQuestHealth());
        //Initialising the corresponding variable to track the fighting stance's movements.
        isFightingStanceMoved = false;
        
        //adding collide effects to the samurai and its fighting stance
        fightStance.addCollisionListener(collision);
        samurai.addCollisionListener(collision);
        
        //obtaining fighting stance position and setting starting point
        fightStance.setPosition(new Vec2(-60,-60));
        fightPositionX = fightStance.getPosition().x;
        fightPositionY = fightStance.getPosition().y;
        
        //obtaining samurai position and setting starting point
        samurai.setPosition(new Vec2(-16, -14));
        samuraiPositionX = samurai.getPosition().x;
        samuraiPositionY = samurai.getPosition().y;
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e); 
        
        if(e.getKeyCode() == KeyEvent.VK_W){
            Vec2 v = samurai.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {
                samurai.jump(JUMPING_SPEED);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            samurai.startWalking(WALKING_SPEED);
            fightStance.startWalking(WALKING_SPEED);
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            samurai.startWalking(-WALKING_SPEED);
            fightStance.startWalking(-WALKING_SPEED);
        }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE){
            
            //overwriting the samurai's x and y coordinates since the samurai may have been moved to new positions
            samuraiPositionX = samurai.getPosition().x;
            samuraiPositionY = samurai.getPosition().y;
            
            //overwriting the fighting stance instance, and positioning the fighting stance at the same spot as the samurai
            fightStance = new SamuraiFight(w);
            fightStance.setPosition(new Vec2(samuraiPositionX, samuraiPositionY));
            //adding collision effects - health reduction etc.
            fightStance.addCollisionListener(collision);
            //destroying the samurai, so only the fighting stance can be visible on-screen
            samurai.destroy();
            //Tracking the fighting stance's movements.
            isFightingStanceMoved=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_T){
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e); 
        
        if(e.getKeyCode() == KeyEvent.VK_D){
            samurai.stopWalking();
            fightStance.stopWalking();
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            samurai.stopWalking();
            fightStance.stopWalking();
        }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE){
            //overwriting the x and y coordinate of the fighting stance since stance may have been moved
            fightPositionX = fightStance.getPosition().x;
            fightPositionY = fightStance.getPosition().y;
            
            //overwriting the samurai instance, updating the health leftover from previous samurai instance and positioning the samurai at the same spot as the fighting stance
            //Also, checks if the boss drop is wielded by the user.
            if(collision.isDropDestroyed==true){
                samurai = new Samurai(w);
                samurai.addSword();
            }
            else {
                samurai = new Samurai(w);
            }
            samurai.setHealth(collision.getNewHealth());
            samurai.setPosition(new Vec2(fightPositionX, fightPositionY));
            //adding collision effects - health reduction etc.
            samurai.addCollisionListener(collision);
            //destroying the fighting stance body, so only the samurai can be visible on-screen
            fightStance.destroy();
            //Tracking the fighting stance's movements.
            isFightingStanceMoved=false;
        }
    }

    public Samurai getSamurai() {
        return samurai;
    } 
    
    public SamuraiFight getFightStance(){
        return fightStance;
    }

    public Collision getCollision() {
        return collision;
    }
    
    public boolean getIsFightingStanceMoved(){
        return isFightingStanceMoved;
    }

}
