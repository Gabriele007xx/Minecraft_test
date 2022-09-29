package client;

import entity.Entity;
import entity.Zombie;
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
        Zombie test = new Zombie(level, textures.get("zombie"));
        test.setLocation(400,400);
        player.setLocation(200,200);
        entities.add(test);
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
            System.out.println();
            for(Entity e : entities)
            {
                e.tick();
            }
            if(player.getAABB().intersects(entities.get(1).getAABB()))
            {
                System.out.println("Collisione");
            }
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
        Texture zombie = new Texture();
        try {
            zombie.loadFromFile(Paths.get("assets/graphics/entity/zombie.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        textures.put("zombie", zombie);
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
