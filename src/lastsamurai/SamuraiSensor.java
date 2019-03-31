/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

/**
 *
 * @author Ali
 */
//Detects the collisions that occur on the Sensor body only e.g. any bodies that come into contact with NPC etc.
public class SamuraiSensor implements SensorListener{
    //The quest display point.
    private QuestPopUp quest;
    //Used to instantiate the quest pop-up.
    private GameWorld w;
    //To see if the quest pop up has been initialised.
    private boolean isQuestPoppedUp;
    
    public SamuraiSensor(GameWorld w) {
        this.w=w;
        isQuestPoppedUp = false;
    }
    
    @Override
    public void beginContact(SensorEvent e) {
        //If the samurai touches the NPC (aka the Sensor body), then the Quest board is initialised.
        if(e.getContactBody() instanceof Samurai){
            quest = new QuestPopUp(w);
            isQuestPoppedUp = true;
        }
    }

    @Override
    public void endContact(SensorEvent e) {
        //If the samurai ends the contact with the NPC, then the 'quest' instance is destroyed.
        if(e.getContactBody() instanceof Samurai){
            quest.destroy();
            isQuestPoppedUp = false;
        }
    }
    
    public boolean getIsQuestPoppedUp(){
        return isQuestPoppedUp;
    }
}
