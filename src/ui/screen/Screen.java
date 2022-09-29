package ui.screen;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;

public abstract class Screen {
    protected RectangleShape screen = new RectangleShape();
    public boolean doShow = false;
    public Screen(int width,int height)
    {
       screen.setFillColor(Color.BLACK);
       screen.setSize(new Vector2f(width,height));
       screen.setOrigin(screen.getSize().x / 2,screen.getSize().y / 2);
       screen.setPosition(1000 / 2, 500 / 2);
    }
    public void render(RenderTarget target)
    {
        target.draw(screen);
    }
}
