import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World

{  private final int WORLDWIDTH = getWidth();
   private final int WORLDHEIGHT = getHeight();
   wall wallTemplate = new wall();
   GreenfootImage wtImg =wallTemplate.getImage();
   private final int WALLHEIGHT = wtImg.getHeight();
   private final int WALLWIDTH = wtImg.getWidth();
   private final int MAPWIDTH = (int)WORLDWIDTH/WALLWIDTH;
   private final int MAPHEIGHT = (int)WORLDHEIGHT/WALLHEIGHT;
   private final String FILENAME = "PacmanLevel1.txt";
   private final String WALLMAKER = "X";
   private final String ball = "B";
   private final String smallBall = "b";
   private final String cherry = "C";
   private final String pacman = "P";
   private final String strowberry = "S";
   String [][] mapArray = new String[MAPHEIGHT][MAPWIDTH];
   
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() throws IOException
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        mapArray = readMap(MAPWIDTH,MAPHEIGHT,FILENAME);
        drawMap(WALLWIDTH,WALLHEIGHT,WALLMAKER,mapArray);
    }
    
    public void drawMap(int wallWidth, int wallHeight, String wallmaker, String[][]mapArray)
    {
      int x = 0;
      int y = 0;
     for( y=0;y<mapArray.length;y++)
     { 
         for(x=0;x<mapArray[y].length;x++)
         {
             if(mapArray[y][x].equals(wallmaker))
             {
                 int wallx = x*wallWidth - wallWidth/2;
                 int wally = y*wallHeight + wallHeight/2;
                 addObject(new wall(), wallx, wally);
             }else if(mapArray[y][x].equals(ball))
             {
                 int wallx = x*wallWidth - wallWidth/2;
                 int wally = y*wallHeight + wallHeight/2;
                 addObject(new ball(), wallx, wally);
             }else if(mapArray[y][x].equals(smallBall))
             {
                 int wallx = x*wallWidth - wallWidth/2;
                 int wally = y*wallHeight + wallHeight/2;
                 addObject(new smallBall(), wallx, wally);
             }else if(mapArray[y][x].equals(cherry))
             {
                 int wallx = x*wallWidth - wallWidth/2;
                 int wally = y*wallHeight + wallHeight/2;
                 addObject(new cherry(), wallx, wally);
             }else if(mapArray[y][x].equals(pacman))
             {
                 int wallx = x*wallWidth - wallWidth/2;
                 int wally = y*wallHeight + wallHeight/2;
                 addObject(new pacman(), wallx, wally);
             }else if(mapArray[y][x].equals(strowberry))
             {
                 int wallx = x*wallWidth - wallWidth/2;
                 int wally = y*wallHeight + wallHeight/2;
                 addObject(new strowberry(), wallx, wally);
             }
         }
     }
    
    }
    public String[][] readMap(int mapWidth, int mapHeight, String filename)throws IOException
     {
        BufferedReader br = null;
       String [][] mArray = new String [mapHeight][mapWidth];
        try{
          br = new BufferedReader(new FileReader(filename));
          String l;
          int mapRow = 0;
        while((l=br.readLine())!=null)
        {
          mArray[mapRow] = l.split("");
          mapRow++;
        }
       }finally{
       if(br!=null)
       br.close();
    
       }
    
       return mArray;
     } 
}
