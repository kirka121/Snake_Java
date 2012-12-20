package snake;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tail extends Entity{
    public static String TAIL = "tail";
    private int length;
    private int[][] tail_position; //([length index][type of piece])
    private int direction;
    
    public Tail (float x, float y, int dir){
        super(x ,y);
        direction = dir;
        if (dir == 2){
            Image tail = ResourceManager.getImage("bodyRighttoLeft");
            setHitBox(2, 1, 22, 30);
            setGraphic(tail);
        }
        if (dir == 1){
            Image tail = ResourceManager.getImage("bodyLefttoRight");
            setHitBox(2, 1, 22, 30);
            setGraphic(tail);
        }
        if (dir == 4){
            Image tail = ResourceManager.getImage("bodyUptoDown");
            setHitBox(2, 1, 22, 30);
            setGraphic(tail);
        }
        if (dir == 3){
            Image tail = ResourceManager.getImage("bodyDowntoUp");
            setHitBox(2, 1, 22, 30);
            setGraphic(tail);
        }
        addType(TAIL);
        length = 1;
        tail_position = new int[100][10];
    }
    
    @Override
    public void update (GameContainer gc, int delta) throws SlickException {
        super.update(gc, delta);
        
        
        
        
    }
}
