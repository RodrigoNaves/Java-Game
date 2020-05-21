/*
 * This code is part of assignment 3 for Programming and Software Development COMP90041
 * As part of the University of Melbourne. May 2020
 * Written by Rodrigo Naves Vargas Student ID: 1092880
 */

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class FileIO {
    NimPlayer[] playersFile = null;
    
    public void saver(NimPlayer playersInSystem[])
    {
       try
       {
           FileOutputStream playersFile = new FileOutputStream("players.dat");
           ObjectOutputStream savePlayers = new ObjectOutputStream(playersFile);
//           for (int i =0; i < playersInSystem.length; i++)
//           {
//               
//           }
            savePlayers.writeObject(playersInSystem);
            savePlayers.close();
           
        }
       catch(Exception a)
       {
           System.out.println("Error in file \n");
       }
    
   }
    public void loader()
    {
        try
            {
                FileInputStream readPlayersFile = new FileInputStream("players.dat");
                ObjectInputStream readPlayers = new ObjectInputStream(readPlayersFile);
                playersFile = (NimPlayer[]) readPlayers.readObject();
                readPlayers.close();

            }
        catch(Exception b)
            {
               //System.out.println("Error in file. File does not exist \n"); 
               playersFile = new NimPlayer[100];
            }
    }
    public NimPlayer[] transferArray()
    {
        return playersFile;
    }
   
} 

