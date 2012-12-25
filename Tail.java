package snake;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tail extends Entity{
    public static String TAIL = "tail";
    private int counter = 0;
    public Tail (float x, float y, int dir){
        super(x ,y);
        /*
        if (Player.direction == 2){
            Image tail = ResourceManager.getImage("tailRighttoLeft");
            setHitBox(2, 1, 22, 30);
            setGraphic(tail);
        }
        if (Player.direction == 1){
            Image tail = ResourceManager.getImage("tailLefttoRight");
            setHitBox(2, 1, 22, 30);
            setGraphic(tail);
        }
        if (Player.direction == 4){
            Image tail = ResourceManager.getImage("tailUptoDown");
            setHitBox(2, 1, 22, 30);
            setGraphic(tail);
        }
        if (Player.direction == 3){
            Image tail = ResourceManager.getImage("tailDowntoUp");
            setHitBox(2, 1, 22, 30);
            setGraphic(tail);
        }
        */
        Image tail = ResourceManager.getImage("body");
        setHitBox(2, 1, 22, 30);
        setGraphic(tail);
        addType(TAIL);
    }
    
    @Override
    public void update (GameContainer gc, int delta) throws SlickException {
        super.update(gc, delta);
        counter++;
        if(counter > GameWorld.tail_length){
            ME.world.remove(this);
            counter = GameWorld.tail_length;
        }
    }
}
