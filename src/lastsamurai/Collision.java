/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastsamurai;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Ali
 */
public class Collision implements CollisionListener{
    
    //the boss monster's drop
    private MageBossDrop drop;
    //Obtaining the boss monster's x and y coordinates
    public float xPosition;
    public float yPosition;
    //declaring visible references to the initiated instances, so those initiated instances can be modified.
    Dragon dragon;
    Football football;
    Sword sword;
    Samurai samurai;
    Health health;
    LastSamurai ls;
    Boss boss;
    SecondHealth healthTwo;
    ThirdHealth healthThree;
    Cat cat;
    QuestHealth questHealth;
    //Boolean to test if the health one power-up is destroyed or not
    public boolean isHealthDestroyed, isHealthTwoGone, isHealthThreeGone, isQuestHealthGone;
    //to count the number of hits to destroy the object.
    private int countHits, mutantHits, count;
    //declaring the new health amount for the samurai.
    public double newHealth;
    //declaring the fighting stance of the dragon
    private DragonFightingStance fireDragon;
    //to find out whether the first health power-up is destroyed, thus the second can be destroyed thereafter.
    private Boolean isOne, isTwo, isThree;
    //Boolean to test if the sword drop power-up is destroyed or not.
    public boolean isDropDestroyed;
    //Boolean to test if the sword drop is wielded by the samurai.
    public boolean isSwordOfWrathUsed;
    
    public Collision(Football football, Dragon dragon, Samurai samurai, Health health, LastSamurai ls, Sword sword, Boss boss, SecondHealth healthTwo, ThirdHealth healthThree, Cat cat, QuestHealth questHealth){
        this.football=football;
        this.boss=boss;
        this.dragon=dragon;
        this.samurai=samurai;
        this.health=health;
        this.ls=ls;
        this.sword=sword;
        this.healthTwo=healthTwo;
        this.healthThree=healthThree;
        this.cat=cat;
        this.questHealth=questHealth;
        //initialising the boss drop
        drop = new MageBossDrop(ls.getWorld());
        drop.setPosition(new Vec2(30,30));
        //variables controlling which items are placed to the inventory at what times and variable to track if the sword drop is wielded by the samurai.
        newHealth = samurai.getHealth();
        countHits = 0;
        mutantHits = 0;
        count = 0;
        isHealthDestroyed=false;
        isHealthTwoGone=false;
        isHealthThreeGone=false;
        isQuestHealthGone=false;
        isDropDestroyed=false;
        isSwordOfWrathUsed=false;
        isOne = false;
        isTwo = false;
        isThree= false;
    }

    public double getNewHealth() {
        return newHealth;
    }
    
    public void setNewHealth(double newHealth){
        this.newHealth=newHealth;
    }
    
    public void addHealth(double add){
        newHealth = samurai.getHealth() + add;
    }
    
    @Override
    public void collide(CollisionEvent e) {
        //creating the collision effect for the fighting stance - reduce health amount
        //Reduces the samurai health via setHealth method, then updates the newHealth variable to the health amount left.
        if(e.getReportingBody() instanceof SamuraiFight){
            if(e.getOtherBody() instanceof Football){
                //incrementing the number of collisions on the object
                countHits++;
                if(countHits==3){
                    //destroying the football object
                    football.destroy();
                }
                samurai.setHealth(newHealth - 1);
                newHealth = samurai.getHealth();
                System.out.println("Health Remaining: "+samurai.getHealth());
            }
            //destroys the dragon, initialises the dragon's fighting stance and increments the number of hits.
            if(e.getOtherBody() instanceof Dragon){
                //incrementing the number of collisions on the object
                countHits++;
                //destroying the dragon
                dragon.destroy();
                //initialising the dragon's fighting stance
                fireDragon = new DragonFightingStance(ls.getWorld());
                //setting the position of the dragon's fighting stance in-place of the destroyed dragon
                fireDragon.setPosition(new Vec2(-15, -5));
                //decreasing the samurai health
                samurai.setHealth(newHealth - 1);
                newHealth = samurai.getHealth();
                System.out.println("Health Remaining: "+samurai.getHealth());
            }
            if(e.getOtherBody() instanceof DragonFightingStance){
                //incrementing the number of collisions on the object
                countHits++;
                if(countHits == 6){
                    //destroying the dragon's fighting stance once the relevant number of hits has been achieved
                    fireDragon.destroy();
                }
                //decreasing the samurai health
                samurai.setHealth(newHealth - 1);
                newHealth = samurai.getHealth();
                System.out.println("Health Remaining: "+samurai.getHealth());
            }
            if(e.getOtherBody() instanceof Sword){
                countHits++;
                if(countHits == 9){
                    sword.destroy();
                }
                samurai.setHealth(newHealth-1);
                newHealth = samurai.getHealth();
                System.out.println("Health Remaining: "+samurai.getHealth());
            }
            if(e.getOtherBody() instanceof Boss){
                countHits++;
                if(countHits==15){
                    //Obtaining the boss monster's x and y coordinates, thus the sword drop can be placed into its death position.
                    xPosition = boss.getPosition().x;
                    yPosition = boss.getPosition().y;
                    //removing the boss monster from the world once the character has hit the boss monster a certain number of times.
                    boss.destroy();
                    //placing the boss drop into the boss's death position.
                    drop.setPosition(new Vec2(xPosition, yPosition));
                }
                samurai.setHealth(newHealth-1);
                newHealth = samurai.getHealth();
                
                System.out.println("Health Remaining: "+samurai.getHealth());
            }
            //If the sword is wielded by the user, then it will take less hits to eradicate the mob.
            if(e.getOtherBody() instanceof Cat && isSwordOfWrathUsed == true){
                mutantHits++;
                if(mutantHits % 1 == 0){
                    cat.destroy();
                    if(mutantHits==1){
                        cat = ls.getWorld().getCatTwo();
                    }
                    else if(mutantHits==2){
                        cat = ls.getWorld().getCatThree();
                    }
                }
                samurai.setHealth(newHealth-1);
                newHealth = samurai.getHealth();
                System.out.println("Health Remaining: "+samurai.getHealth());
            }
            else if(e.getOtherBody() instanceof Cat){
                mutantHits++;
                if(mutantHits % 3 == 0){
                    cat.destroy();
                    if(mutantHits==3){
                    cat = ls.getWorld().getCatTwo();
                    }
                    else if(mutantHits==6){
                        cat = ls.getWorld().getCatThree();
                    }
                }
                samurai.setHealth(newHealth-1);
                newHealth = samurai.getHealth();
                System.out.println("Health Remaining: "+samurai.getHealth());
                System.out.println("MutantHits: "+mutantHits);
            }
            /**if(e.getOtherBody() instanceof Kobold && isSwordOfWrathUsed==true){
                samurai damage increases by x2 as the sword of wrath is wielded....
                countHits++;
                if(countHits==18)....
            }
            if(e.getOtherBody() instanceof Kobold && isSwordOfWrathUsed==false){
                if sword of wrath isn't wielded by the samurai, then the samurai's damage remains the same...
                countHits++;
                if(countHits==20)....
            }**/
        }
        
        //creating collision effect for the samurai - reduce health by double the rate
        else if (e.getReportingBody() instanceof Samurai) {
            if(e.getOtherBody() instanceof Football || e.getOtherBody() instanceof Dragon || e.getOtherBody() instanceof DragonFightingStance){
                samurai.setHealth(newHealth - 2);
                newHealth = samurai.getHealth();
                System.out.println("Health Remaining: "+samurai.getHealth());
            }
            else if(e.getOtherBody() instanceof Health){
                /*
                        What if user went from first floor health, then ground, then top floor?
                        What if ground> first> top floor power-ups in order?
                            
                        Find a way to detect the user colliding with the second floor or first floor power-up...
                        Using samurai's position and the power-up position doesn't work as since world is viewToWorld, their coordinates change in relation to the samurai's movement.
                */
                health.destroy();
                isHealthDestroyed=true;
            }
            else if(e.getOtherBody() instanceof SecondHealth){
                healthTwo.destroy();
                isHealthTwoGone=true;
            }
            else if(e.getOtherBody() instanceof ThirdHealth){
                healthThree.destroy();
                isHealthThreeGone=true;
            }
            else if(e.getOtherBody() instanceof MageBossDrop){
                drop.destroy();
                isDropDestroyed=true;
            }
            else if(e.getOtherBody() instanceof QuestHealth){
                questHealth.destroy();
                isQuestHealthGone=true;
            }
        }
    }
    
    public Samurai getSamurai(){
        return samurai;
    }
    
    public void destroySamurai(){
        samurai.destroy();
    }
    
    public void setIsSwordOfWrathUsed(boolean isSwordOfWrathUsed){
        this.isSwordOfWrathUsed=isSwordOfWrathUsed;
    }
}
