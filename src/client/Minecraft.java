package client;

import entity.Entity;
import entity.player.Movable;
import entity.player.Player;
import ui.Hotbar;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import util.LoadSaveFile;
import util.Timer;
import world.Level;
import world.ServerLevel;
import world.village.Village;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Minecraft {
    private RenderWindow window;
    private int window_width = 1000;
    private int window_height = 500;
    public static HashMap<String, Texture> textures = new HashMap<String, Texture>();
    public Village village;
    private Hotbar hotbar = new Hotbar();
    public int ID_selected;
    private Vector2f mousepos;
    public ArrayList<Entity> entities = new ArrayList<>();
    private Level level;
    public Player player;
    private Movable movable = new Movable();
    public Minecraft()
    {
        window = new RenderWindow(new VideoMode(window_width,window_height),"Game");
        initTex();
        initLevel();
        player = new Player(level, textures.get("player"));
        entities.add(player);
        Timer.clock.restart();
    }
    public void run()
    {
        while(window.isOpen())
        {
            update();
            render();
        }

    }
    private void update()
    {
        //update mousepos
        mousepos = this.window.mapPixelToCoords(Mouse.getPosition(window));
        pullEvent();
        hotbar.updateTitleScreen(ID_selected);
        hotbar.update(mousepos);
        if(Timer.clock.getElapsedTime().asSeconds() >= 1f/Timer.TICK_PER_SECOND)
        {
            movable.Update(player);
        }

    }
    private void render()
    {
        window.clear();
        level.render(window);
        for(Entity e : entities)
        {
            e.render(window);
        }
        hotbar.render(window);
        window.display();
    }
    private void initLevel()
    {
        level = new ServerLevel(textures.get("village"));
    }

    private void initTex()
    {
        Texture player = new Texture();
        try {
            player.loadFromFile(Paths.get("assets/graphics/entity/player.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        textures.put("player", player);

        Texture village_base = new Texture();
        try {
            village_base.loadFromFile(Paths.get("assets/graphics/world/village.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        textures.put("village", village_base);
    }
    private void pullEvent()
    {
        for(Event event : window.pollEvents())
        {
            switch (event.type)
            {
                case CLOSED:
                    window.close();
                    break;
            }
        }
    }

    public Vector2f getMousepos() {
        return mousepos;
    }
}
