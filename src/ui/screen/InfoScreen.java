package ui.screen;

import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;

public class InfoScreen extends Screen{
    private Text title = new Text();
    private Font font = new Font();
    private String string_title_;
    public InfoScreen(int width, int height,String title) {
        super(width, height);
        this.title.setCharacterSize(15);
        this.title.setString(title);
        this.title.setPosition(screen.getPosition().x - screen.getSize().x / 2,screen.getPosition().y - screen.getSize().y / 2);
    }
    public void update(Vector2f mousepos)
    {
      if(screen.getGlobalBounds().contains(mousepos))
      {
          if(Mouse.isButtonPressed(Mouse.Button.LEFT))
          {
              title.setString(string_title_);
              doShow = true;

          }
      }
    }

    public void setString_title_(String string_title_) {
        this.string_title_ = string_title_;
    }

    @Override
    public void render(RenderTarget target) {
        target.draw(screen);
        target.draw(title);
    }
}
