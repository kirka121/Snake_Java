package snake;

import it.randomtower.engine.World;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameWorld extends World{
    public static int tail_length = 0;
    private float[][] tail_xy;
    
    public GameWorld(int id, GameContainer gc){
        super(id, gc);
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException{
        super.init(gc, game); 
        Player p = new Player(getWidth()/2, getHeight()/2);
        add(p);
        Random generate = new Random();
        int r_x = generate.nextInt(width-32);
        int r_y = generate.nextInt(height-32);
        SquidMonster m = new SquidMonster(r_x, r_y);
        add(m);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException{
        super.update(gc, game, delta);
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException{
        super.render(gc, game, g);    
    } 
}
