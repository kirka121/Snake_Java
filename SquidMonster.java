package snake;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class SquidMonster extends Entity{
    public static String SQUID_MONSTER = "squid monster";
    private int frameCount = 0;
    private int nextFrame = 500;
    private int frame = 0;
    private int health;
    
    public SquidMonster (float x, float y){
        super(x, y);
        Image monster = ResourceManager.getImage("squidMonster");
        setHitBox(8, 1, 22, 30);
        setGraphic(monster);
        addType(SQUID_MONSTER);
        health = 500;
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException{
        super.update(gc, delta);
    }
    
    public void collisionResponse(Entity e){
        health -= 50;
        if (health <= 0){
            this.destroy();
            GameWorld.tail_length+=20;
            Random generate = new Random();
            int r_x = generate.nextInt(world.width-32);
            int r_y = generate.nextInt(world.height-32);
            SquidMonster m = new SquidMonster(r_x, r_y);
            ME.world.add(m);
        }
    }
}
