package snake;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet extends Entity {
    public static String BULLET = "bullet";
    private final String[] enemies = { SquidMonster.SQUID_MONSTER };
    private GameContainer gc;
    private int direction;
    public Bullet (float x, float y, int dir){
        super(x ,y);
        direction = dir;
        if (direction == 3 || direction == 4){
            Image bullet = ResourceManager.getImage("bullet");
            setGraphic(bullet);
            setHitBox(2, 1, 4, 6);
        }
        if (direction == 1 || direction == 2){
            Image bullet = ResourceManager.getImage("bullet_v");
            setGraphic(bullet);
            setHitBox(1, 2, 6, 4);
        }
        addType(BULLET);
    } 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException{
        if (direction == 4){
           y -= (0.7 * delta);  
        }
        if (direction == 3){
           y += (0.7 * delta);  
        }
        if (direction == 2){
           x += (0.7 * delta);  
        }
        if (direction == 1){
           x -= (0.7 * delta);  
        }
        if(collide(enemies, x, y) != null){
            this.destroy();
        }
        if (y < 0 || y > world.height || x < 0 || x > world.width){
        	ME.world.remove(this);
        }
        super.update(gc, delta);
    }
}
