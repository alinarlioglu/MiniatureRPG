/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

/**
 *
 * @author Ali
 */
public class BossTracker implements StepListener{
    
    private final Boss BODY;
    private int countSteps;
    private float walkingSpeed;
    
    public BossTracker(Boss BODY){
        this.BODY = BODY;
        countSteps = 0;
        walkingSpeed = -2f;
        
        BODY.startWalking(walkingSpeed);
    }

    @Override
    public void preStep(StepEvent e){
        
    }
    
    /**
     * Changes the boss monster's direction every time it walks a certain number of steps.
     * @param e 
     */
    @Override
    public void postStep(StepEvent e) {
        //counts the number of steps everytime a new 
        countSteps++;
        if(countSteps==400){
            countSteps=0;
            //Changes walking speed to other direction.
            walkingSpeed *= -1;
            //Applies it to the walker.
            BODY.startWalking(walkingSpeed);
        }
    }
    
    
}
