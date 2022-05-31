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
    GreenfootImage[] idle = new GreenfootImage[3];
    /**
     * Constructor
     */
    
    public Bee()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/bee_idle/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    /**
     * Animates the bee
     */
    int imageIndex = 0;
    public void animateBee()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
        }
        else
        {
            if(Greenfoot.isKeyDown("right"))
            {
                move(5);
            }
        }
        
        //remove apple if bee is touching it
        eat();
        //animates the bee
        animateBee();
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
