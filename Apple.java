import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for bee
 * 
 * @author Brian 
 * @version May 2022
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Apple falls downward
        int x = getX();
        int y = getY() + 2;
        setLocation(x, y);
        
        //Remove Apple and draws game over when apple is at the bottom
        MyWorld  world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
