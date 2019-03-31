/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.*;
import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Ali
 */
public class GameWorld extends World{
    
    //Obtaining the boss monster's x and y coordinates
    public float xPosition;
    public float yPosition;
    //declaring an enemy instance
    private Football football;
    //declaring an enemy instance
    private Dragon dragon;
    //declaring a health power-up instance
    private Health health;
    private SecondHealth healthTwo;
    private ThirdHealth healthThree;
    private NPCHealth healthNpc;
    private QuestHealth questHealth;
    //declaring the sword instance
    private Sword sword;
    //declaring the boss monster instance
    private Boss boss;
    //Declaring an npc variable.
   private NPC npc;
   //Declaring a SamuraiSensor which detects whether the NPC and Samurai have collided, thus initialising the QuestPopUp.
   private SamuraiSensor samuraiSensor;
   //The quest mob.
   private Cat cat, catTwo, catThree;
    
    public GameWorld() {
        super();
        
        //the bottom-most floor (aka ground floor)
        Shape groundShape = new BoxShape(35, 0.25f);
        Body groundBody = new StaticBody(this, groundShape);
        groundBody.setPosition(new Vec2(-15,-16));
        //setting a weight on the ground
        SolidFixture ground = new SolidFixture(groundBody, groundShape);
        ground.setDensity(1);
        
        //a health power-up
       health = new Health(this);
       health.setPosition(new Vec2(16.75f,-15.25f));
       
        //an enemy
        football = new Football(this);
        football.setPosition(new Vec2(10,-14.2f));
        
        //the box object at the bottom-most floor (aka ground floor)
        Shape box = new BoxShape(1,1.25f);
        Body boxBody = new StaticBody(this, box);
        boxBody.setPosition(new Vec2(15, -15));
        
        //the first floor
        Shape floorOne = new BoxShape(20, 0.25f);
        Body floorOneBody = new StaticBody(this, floorOne);
        floorOneBody.setPosition(new Vec2(-10, -10));
        
        //an enemy
        dragon = new Dragon(this);
        dragon.setPosition(new Vec2(-10, -5.5f));
        
        //the second floor
        Shape floorTwo = new BoxShape(12, 0.25f);
        Body floorTwoBody = new StaticBody(this, floorTwo);
        floorTwoBody.setPosition(new Vec2(0, 0));
        
        //the box object at the first floor
        Body boxBody2 = new StaticBody(this, box);
        boxBody2.setPosition(new Vec2(-17, -6f));
        
        healthTwo = new SecondHealth(this);
        healthTwo.setPosition(new Vec2(-25, -9.25f));
        
        //an enemy
        sword = new Sword(this);
        sword.setPosition(new Vec2(-2, 2));
        
        //a health power-up
        healthThree = new ThirdHealth(this);
        healthThree.setPosition(new Vec2(5, 0.8f));
        
        //obstacle to jump on to reach the second floor
        Shape box3 = new BoxShape(1f, 1.3f);
        Body boxBody3 = new StaticBody(this, box3);
        boxBody3.setPosition(new Vec2(17, 3));
        
        //the second floor
        Shape floorThree = new BoxShape (15, -.25f);
        Body floorThreeBody = new StaticBody(this, floorThree);
        floorThreeBody.setPosition(new Vec2(-5, 6));
        
        //adding the boss monster to the second floor.
        boss = new Boss(this);
        boss.setPosition(new Vec2(-4, 15f));
        this.addStepListener(new BossTracker(boss));
        
        //-1 floor
        Shape negativeOne = new BoxShape(20, 0.25f);
        Body negativeOneBody = new StaticBody(this, negativeOne);
        negativeOneBody.setPosition(new Vec2(51, -25));
        
        //box to reach the -1 floor
        Shape negativeBox = new BoxShape(1, 1.25f);
        Body negativeBoxBody = new StaticBody(this, negativeBox);
        negativeBoxBody.setPosition(new Vec2(25, -21));
        
        //Initialising an NPC character
        npc = new NPC(this);
        //Adding the SensorListener to the Sensor body (aka the NPC) which enables collisions to occur and helps to detect which bodies touch or pass through the NPC.
        //Used to instantiate the quest board whenever the Samurai touches or goes through the NPC.
        //Once the Samurai doesn't touch or go through the NPC, then the quest board is destroyed.
        samuraiSensor = new SamuraiSensor(this);
        npc.getSensor().addSensorListener(samuraiSensor);
        
        questHealth = new QuestHealth(this);
        questHealth.setPosition(new Vec2(50, -24f));
        
        cat = new Cat(this);
        cat.setPosition(new Vec2(54, -23f));
        
        catTwo = new Cat(this);
        catTwo.setPosition(new Vec2(58, -23f));
        
        catThree = new Cat(this);
        catThree.setPosition(new Vec2(62, -23f));
    }
    
    public SecondHealth getHealthTwo(){
        return healthTwo;
    }
    
    public Cat getCat(){
        return cat;
    }
    
    public Cat getCatTwo(){
        return catTwo;
    }
    
    public Cat getCatThree(){
        return catThree;
    }
    
    public SamuraiSensor getSamuraiSensor(){
        return samuraiSensor;
    }
    
    public NPC getNpc(){
        return npc;
    }

    public Boss getBoss(){
        return boss;
    }
    
    public Football getFootball() {
        return football;
    }
    
    public Dragon getDragon(){
        return dragon;
    }

    public Health getHealth() {
        return health;
    }
    
    public QuestHealth getQuestHealth(){
        return questHealth;
    }
    
    public Sword getSword(){
        return sword;
    }
    
    public ThirdHealth getHealthThree(){
        return healthThree;
    }
}
