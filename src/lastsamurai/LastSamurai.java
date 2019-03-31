/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Ali
 */
public class LastSamurai {
    
    //declaring the instances required to power-up and define the game
    private GameWorld world;
    private MyView view;
    private KeyController keyMovement;
    private JFrame frame;
    private QuestStart questStart;
    // to hold the buttons to control the bag
    private Container buttons;
    
    public LastSamurai() {
        // display the view in a frame
        frame = new JFrame("Last Samurai");
         // make the world
        world = new GameWorld();
        //Calling a front-window to view the appearance and functions of the game e.g. graphics etc.
        view = new MyView(world, 930, 645, this);
        // initialise the key movements class
        keyMovement = new KeyController(world, view, frame, this);
        // initialises the wolf quest tracker.
        questStart = new QuestStart(this);
        // adding the key events to the view, so the key event can work when pressed
        view.addKeyListener(keyMovement);
        view.addKeyListener(questStart);
        // make the window visible, thus received events can work e.g. key events
        view.setFocusable(true);
        view.setVisible(true);
        //Making the world move with the samurai's position.
        world.addStepListener(new SamuraiStep(view, keyMovement));
        
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        //frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // adding an interface for the bag function
        buttons = new ControlPanel(this, keyMovement.getCollision(), keyMovement);
        // adding the buttons to the frame
        frame.add(buttons, BorderLayout.EAST);
        // make the window visible, thus received events can work e.g. key events
        frame.setVisible(true);
        
        // executes the world
        world.start();
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        new LastSamurai();
    }

    public KeyController getKeyMovement() {
        return keyMovement;
    }
    
    public GameWorld getWorld(){
        return world;
    }
    
    public void stopWorld(){
        world.stop();
    }
    
    public void startWorld(){
        world.start();
    }

    public Container getButtons() {
        return buttons;
    }

    public MyView getView() {
        return view;
    }
    
    //Making the world move according to the samurai's position.
    public void addSamuraiStep(){
        world.addStepListener(new SamuraiStep(view, keyMovement));
    }
    
}
