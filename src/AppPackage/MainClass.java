/*
 *   I am Ahmed Reda Mahfouz
 *   Student at the Faculty of Computing and Information Menoufia University 
 *   Department of Computer Science
 *
 *   *       Please Visit us at www.github.com/amahfouz50     *
 *  This Program was Developed by www.github.com/amahfouz50 forums Team
 *  *           Please Don't Remove This Comment       *
 */  

/**
 *
 *   @author Ahmed Mahfouz
 */
package AppPackage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainClass 
{
    FileInputStream FIS;
    BufferedInputStream BIF;
    
    public  Player player;
    
    public long pauselocation;
    public long songTotalLength;
    public String fileLocation;
    public void Stop()
    {
        if (player !=null) 
        {
            player.close();
            pauselocation = 0;
            songTotalLength = 0 ;
            //MP3Player.Display.setText("");
        }
    }
    
   

    public void Pause()
    {
        if (player !=null) 
        {
            try {
                pauselocation = FIS.available();
                player.close();

            } catch (IOException ex) {
            }
        }
    }

    public void Resume()
    {
        try {
            FIS = new FileInputStream(fileLocation);
            BIF = new BufferedInputStream(FIS);
            player = new Player(FIS);
            FIS.skip(songTotalLength - pauselocation);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    player.play();
                    
                } catch (JavaLayerException ex) {
                }
            }
        }.start();
        
    }
    
    
    
    public void Play(String path)
    {
        try {
            FIS = new FileInputStream(path);
            BIF = new BufferedInputStream(FIS);
            player = new Player(FIS);
           songTotalLength = FIS.available();
           fileLocation = path+"";
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    player.play();
                    
                } catch (JavaLayerException ex) {
                }
            }
        }.start();
        
    }
    
    
}
