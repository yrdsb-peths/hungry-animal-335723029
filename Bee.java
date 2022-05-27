import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Bee
 * 
 * @author Brian Xiao
 * @version May 20th
 */
public class Bee extends Actor
{
    GreenfootSound beeBuzz = new GreenfootSound("608783__delta12studio__bee.ogg");
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
        else
        {
            if(Greenfoot.isKeyDown("right"))
            {
                move(3);
            }
        }
        
        //remove apple if bee is touching it
        eat();
    }
    
    /**
     * Spawns a new apple if bee eats apple.
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            beeBuzz.play();
        }
    }
}
