/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 *
 * Sets the world to move along with the Samurai and the Samurai's fighting stance. 
 * Helps to widen the game world and give it more visual enhancement.
 * 
 * @author Ali
 */
public class SamuraiStep implements StepListener{

    MyView view;
    KeyController key;
    
    public SamuraiStep(MyView view, KeyController key) {
        this.view=view;
        this.key=key;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    /**
     * Sets the world to move along with the Samurai's movements. 
     * Also, sets the world to move along with the Fighting stance within the same position as where the Samurai left from.
     * @param e 
     */
    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(key.getSamurai().getPosition()));
        if(key.getIsFightingStanceMoved() == true){
            view.setCentre(new Vec2(key.getFightStance().getPosition()));
        }
        
    }
    
    
    
}
