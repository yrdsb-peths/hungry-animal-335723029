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
    GreenfootImage[] idleRight = new GreenfootImage[3];
    GreenfootImage[] idleLeft = new GreenfootImage[3];
    
    // The direction that the bee is facing
    String facing = "right";
    /**
     * Constructor
     */
    
    public Bee()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/bee_idle/idle" + i + ".png");
            idleRight[i].scale(80, 80);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/bee_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80, 80);
        }
        
        
        //Intial elephant image
        setImage(idleRight[0]);
    }
    /**
     * Animates the bee
     */
    int imageIndex = 0;
    public void animateBee()
    {
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        } else 
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
            facing = "left";
        }
        else
        {
            if(Greenfoot.isKeyDown("right"))
            {
                move(4);
                facing = "right";
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
