/*
 * This code is part of assignment 3 for Programming and Software Development COMP90041
 * As part of the University of Melbourne. May 2020
 * Written by Rodrigo Naves Vargas Student ID: 1092880
 */


import java.io.Serializable;
public class NimHumanPlayer extends NimPlayer implements Serializable
{
    
    public NimHumanPlayer(String username, String LastName, String FirstName)
    {
       super(username,LastName,FirstName);
       
    }
   
     public int removeStone() // this method will return the number of stones in the last turn
    {
            stoneString = ScanningInput.nextLine();
            try
            {
                stones = Integer.parseInt(stoneString);
            }
            catch (NumberFormatException c)
            {
                stones =0;
            }
            return stones;
    }
}
