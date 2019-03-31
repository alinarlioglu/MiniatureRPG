/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Ali
 */
public class MyView extends UserView{

    //Variable to hold the background image.
    private Image background;
    //Referring to the game.
    private LastSamurai game;
    
    
    public MyView(World w, int width, int height, LastSamurai game) {
        super(w, width, height);
        this.game=game;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g); 
        
        //Identifies the image, then obtains it and holds it via the 'background' variable.
        background = new ImageIcon("image/summer.jpg").getImage();
        g.drawImage(background, 0, 0, 810, 645, this);
        
        //health bar base colour - so decreased health is visible
        g.setColor(Color.white);
        g.fillRect(15, 30, 200, 20);
        g.drawRect(15, 30, 200, 20);
    } 
    
    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        
        //obtaining the samurai health via newHealth variable in Collision class as the program can obtain that variable easier than samurai's Health variable - health rectangle updates more regularly.
        //the health bar colour representation - top colour of rectangle = health is at max
        if(game.getKeyMovement().getCollision().getNewHealth() == 10){
            g.setColor(Color.red);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);        
        }
        //changing the rectangle size according to health left - overwriting the previously drawn rectangle
        if(game.getKeyMovement().getCollision().getNewHealth() == 9){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 180, 20);
            g.drawRect(15, 30, 180, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 8){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 160, 20);
            g.drawRect(15, 30, 160, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 7){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 140, 20);
            g.drawRect(15, 30, 140, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 6){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 120, 20);
            g.drawRect(15, 30, 120, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 5){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 100, 20);
            g.drawRect(15, 30, 100, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 4){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 80, 20);
            g.drawRect(15, 30, 80, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 3){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 60, 20);
            g.drawRect(15, 30, 60, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 2){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 40, 20);
            g.drawRect(15, 30, 40, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 1){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 20, 20);
            g.drawRect(15, 30, 20, 20);
        }
        else if(game.getKeyMovement().getCollision().getNewHealth() == 0 || game.getKeyMovement().getCollision().getNewHealth() < 0){
            //drawing the base first, then the health bar - so, the decreased health is visible as the base is constantly re-drawn along with the health bar
            g.setColor(Color.white);
            g.fillRect(15, 30, 200, 20);
            g.drawRect(15, 30, 200, 20);
            
            g.setColor(Color.red);
            g.fillRect(15, 30, 0, 20);
            g.drawRect(15, 30, 0, 20);
            
            //stopping the game as the health has reached 0 or less.
            g.setColor(Color.red);
            g.drawString("GAME OVER!", 315, 310);
            game.stopWorld();
        }
        //If the QuestPopUp is initialised, then type the Quest details will appear on the pop up accordingly.
        if(game.getWorld().getSamuraiSensor().getIsQuestPoppedUp() == true){
            g.setColor(Color.yellow);
            g.drawString("Please help me! Mutated cats have invaded", 265, 180);
            g.drawString("the area, I need help clearing them out.", 265, 200);
            g.drawString("Press key 'T' to accept.", 265, 220);
        }
    }
}
