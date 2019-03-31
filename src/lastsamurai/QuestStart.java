/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Ali
 */
public class QuestStart extends KeyAdapter {
    //To track the number of wolf kills by the user.
    private int wolfKillCount;
    //Making it visible to access certain elements in LastSamurai class.
    private LastSamurai game;
    
    public QuestStart(LastSamurai game) {
        this.game=game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e); 
        if(e.getKeyCode() == KeyEvent.VK_T && game.getWorld().getSamuraiSensor().getIsQuestPoppedUp() == true){
            wolfKillCount = 0;
            System.out.println("Quest initiated!!!");
        }
    }
    
    public int getWolfKillCount(){
        return wolfKillCount;
    }
    
    public void setWolfKillCount(int n){
        wolfKillCount = wolfKillCount + n;
    }
}
