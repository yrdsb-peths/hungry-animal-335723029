import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Bee
 * 
 * @author Brian Xiao
 * @version May 20th
 */
public class Bee extends Actor
{
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        else
        {
            if(Greenfoot.isKeyDown("right"))
            {
                move(1);
            }
        }
        
        //remove apple if bee is touching it
        removeTouching(Apple.class);
    }
}
