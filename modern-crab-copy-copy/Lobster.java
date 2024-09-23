// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Lobster extends Actor
{

    /**
     * 
     */
    public Lobster()
    {
        turn(Greenfoot.getRandomNumber(360));
    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        eatWorm();
        eatCrab();
        if (isGameOver()) {
            trasitionToGameOverWorld();
        }
    }

    /**
     * when the list of worm objects in the world is emoty, we win the game!
     */
    public boolean isGameOver()
    {
        World world = getWorld();
        if (world.getObjects(Crab.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * make the current world, the GameWonWorld
     */
    public void trasitionToGameOverWorld()
    {
        World GameOverWorld =  new GameOverWorld();
        Greenfoot.setWorld(GameOverWorld);
        Greenfoot.playSound("scary-game-effect-131801.mp3");
    }

    /**
     * 
     */
    public void moveAround()
    {
        move(4);
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (isAtEdge()) {
            turn(180);
        }
    }

    /**
     * 
     */
    public void eatCrab()
    {
        Actor crab = getOneIntersectingObject(Crab.class);
        if (crab != null) {
            World world = getWorld();
            world.removeObject(crab);
            Greenfoot.playSound("scary-game-effect-131801.mp3");
        }
    }

    /**
     * 
     */
    public void eatWorm()
    {
        Actor worm = getOneIntersectingObject(Worm.class);
        if (worm != null) {
            World World = getWorld();
            World.removeObject(worm);
            getWorld().addObject( new Lobster(), getX(), getY());
        }
    }
}
