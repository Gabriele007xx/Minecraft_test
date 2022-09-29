package util;

import java.io.File;
import java.io.IOException;

public class LoadSaveFile {
    public boolean readVillage()
    {
        return true;
    }
    public boolean doesSaveexist()
    {
        File file = new File(Constants.SAVE_NAME_FILE);
        if(file.exists())
        {
            return true;
        }
        return false;
    }
    public boolean SaveVillage()
    {
        if(doesSaveexist())
        {

        }
        else
        {
            File file = new File(Constants.SAVE_NAME_FILE);
            try
            {
                file.createNewFile();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return true;
    }

}
