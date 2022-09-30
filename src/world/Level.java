package world;

import entity.Entity;
import org.jetbrains.annotations.Nullable;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2i;
import phys.Vec2;

import java.util.ArrayList;

public abstract class Level {
private float gridSizeFloat;
private int layers;
private int gridSize;
private Vector2i map_size = new Vector2i(50,50);
private ArrayList<ArrayList<ArrayList<Tile>>> map = new ArrayList<>();
public ArrayList<Entity> entities = new ArrayList<>();
public Level(Texture texture)
{
    this.gridSizeFloat = 32.0f;
    this.gridSize = (int) gridSizeFloat;
    this.layers = 1;
    for (int x = 0; x < map_size.x; x++)
    {
        this.map.add(new ArrayList<ArrayList<Tile>>());
        for(int y = 0; y < map_size.y; y++)
        {
            this.map.get(x).add(new ArrayList<Tile>());
            for(int z=0;z < layers; z++)
            {
                this.map.get(x).get(y).add(new Tile(texture,x*gridSize,y*gridSize));
            }
        }
    }
}
    public void render(RenderTarget target)
    {
        for(ArrayList<ArrayList<Tile>> x :  map)
        {
            for(ArrayList<Tile> y : x)
            {
                for(Tile z : y)
                {
                    z.render(target);
                }
            }
        }
    }

    @Nullable
    public <T extends Entity> T findNearestEntity(Vec2 point, double range,Class type)
    {
        if(entities.get(0) instanceof T)
        {

        }
        double dist1 = entities.get(0).DistanceTo(entities.get, point) >=)
        for(Entity e : entities)
        {

        }
        return null;
    }
}
