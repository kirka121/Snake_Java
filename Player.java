package snake;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Entity {
    private int direction = 2; //(1 = left, 2 = right, 3 = down, 4 = up)
    public double speed = 0.1;
    public static String SNAKE = "snake";
    private Image playerUp, playerRight, playerLeft, playerDown;
    private int fireRate = 50;
    private int milliCount = 0;
    private int millis = fireRate;
    private int milliStep = millis / 5;
    public Player(float x, float y) {
        super(x,y);
        playerUp = ResourceManager.getImage("playerUp");
        playerRight = ResourceManager.getImage("playerRight");
        playerLeft = ResourceManager.getImage("playerLeft");
        playerDown = ResourceManager.getImage("playerDown");
        setGraphic(playerRight);
        setHitBox(2, 6, 31, 29);
        addType(SNAKE);
        define("right", Input.KEY_RIGHT, Input.KEY_D);
        define("left", Input.KEY_LEFT, Input.KEY_A);
        define("up", Input.KEY_UP, Input.KEY_W);
        define("down", Input.KEY_DOWN, Input.KEY_S);
        define("shoot", Input.KEY_SPACE);
    } 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException{
        super.update(gc, delta);
        Input input = gc.getInput();
        if(check("right") && direction != 1){
            setGraphic(playerRight);
            direction = 2;
        }
        if(check("left") && direction != 2){
            setGraphic(playerLeft);
            direction = 1;
        }
        if(check("down") && direction != 4){
            setGraphic(playerDown);
            direction = 3;
        }
        if(check("up") && direction != 3){
            setGraphic(playerUp);
            direction = 4;
        }
        switch (direction){
            case 1: x -= (speed * delta); break;
            case 2: x += (speed * delta); break;
            case 3: y += (speed * delta); break;
            case 4: y -= (speed * delta); break;
            default:  break;      
        }
        if ((y + playerUp.getHeight() > world.height) || (y < 0) || (x < 0) || (x + playerUp.getWidth() > world.width)){
            speed = 0.0;
            //lost game condition here
        }
        
        /*
        if(direction == 2){
            Tail t = new Tail(x - 30, y, direction);
            t.setCentered(false);
            ME.world.add(t);
        }
        if(direction == 1){
           Tail t = new Tail(x + 30, y, direction);
           t.setCentered(false);
           ME.world.add(t); 
        }
        if(direction == 4){
            Tail t = new Tail(x, y + 30, direction);
            t.setCentered(false);
            ME.world.add(t);
        }
        if(direction == 3){
           Tail t = new Tail(x, y - 30, direction);
           t.setCentered(false);
           ME.world.add(t); 
        }
        */
        
        
        if(check("shoot")){
            milliCount += delta;
            while (milliCount > milliStep) {
                milliCount -= milliStep;
                millis -= milliStep;
            }
            if (millis <= 0){
                if (direction == 1 || direction == 2){
                    Bullet b = new Bullet(x, y + 16, direction);
                    b.setCentered(true);
                    ME.world.add(b);
                } else {
                    Bullet b = new Bullet(x + 16, y, direction);
                    b.setCentered(true);
                    ME.world.add(b);
                }
                millis = fireRate;
            }
        }
    }
}
