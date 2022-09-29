package ui;

import ui.screen.InfoScreen;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Hotbar {
    private ArrayList<ImageButton> buttons = new ArrayList<>();
    private ArrayList<Texture> textures = new ArrayList<>();
    private ArrayList<ProgressBar> progressBars = new ArrayList<>();
    public InfoScreen info_s = new InfoScreen(250,250,"N/A");
    public Hotbar()
    {
        //Init ImageButtons


    }
    public void render(RenderTarget target)
    {
        for(ImageButton button : buttons)
        {
            button.render(target);
        }
        for(ProgressBar progressBar : progressBars)
        {
            progressBar.render(target);
        }
        if(info_s.doShow)
        {
            info_s.render(target);
        }
    }
    public void update(Vector2f mousepos)
    {
        for(ImageButton button : buttons)
        {
            if(button.getSprite().getGlobalBounds().contains(mousepos))
            {
                if(Mouse.isButtonPressed(Mouse.Button.LEFT))
                {
                    if(button instanceof InfoButton)
                    {
                        info_s.doShow = true;
                    }
                }
            }

        }

    }
    public void updateTitleScreen(int id)
    {


            if(id == 1)
            {

                info_s.setString_title_("Mine");
            }
    }
}
