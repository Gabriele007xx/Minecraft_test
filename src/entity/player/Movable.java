package entity.player;

import org.jsfml.window.Keyboard;

public class Movable {
public void Update(Player player)
{
    if(Keyboard.isKeyPressed(Keyboard.Key.W))
    {
        player.getSprite().move(0,-1);
    }
    if(Keyboard.isKeyPressed(Keyboard.Key.S))
    {
        player.getSprite().move(0,1);
    }
    if(Keyboard.isKeyPressed(Keyboard.Key.A))
    {
        player.getSprite().move(-1,0);
    }
    if(Keyboard.isKeyPressed(Keyboard.Key.D))
    {
        player.getSprite().move(1,0);
    }
}
}
