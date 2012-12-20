package snake;

import it.randomtower.engine.ResourceManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Snake extends StateBasedGame {
    public static int GAME_STATE = 1;

    public Snake(String title) {
        super(title);
    }
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        try {
            ResourceManager.loadResources("data/resources.xml");
        } catch (IOException ex){
            Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
        }
        addState(new GameWorld(GAME_STATE, gc));
        enterState(GAME_STATE);
    }
            
    public static void main(String[] args) throws SlickException {
        System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "\\lib");
        AppGameContainer app = new AppGameContainer(new Snake("Snake by Kirka"));
        app.setDisplayMode(640, 448, false);
        app.setTargetFrameRate(60);
        app.start();
    }
}