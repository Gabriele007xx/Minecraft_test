package ui;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;

public class ImageButton {
    private Texture texture = new Texture();
    private Sprite sprite = new Sprite();
    public ImageButton(Texture texture,float x,float y)
    {
        this.texture = texture;
        sprite.setTexture(this.texture);
        sprite.setPosition(new Vector2f(x,y));
    }
    public void render(RenderTarget target)
    {
        target.draw(sprite);
    }

    public Sprite getSprite() {
        return sprite;
    }
}
