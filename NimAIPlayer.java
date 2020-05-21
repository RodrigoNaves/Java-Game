/*
 * Written by Rodrigo Naves Vargas
 */


import java.io.Serializable;
/*
	NimAIPlayer.java
	
	This class is provided as a skeleton code for the tasks of 
	Sections 2.4, 2.5 and 2.6 in Project C. Add code (do NOT delete any) to it
	to finish the tasks. 
*/

public class NimAIPlayer extends NimPlayer implements Serializable
{
    

    
    
    public NimAIPlayer(String username, String LastName, String FirstName)
     {
         super(username,LastName,FirstName);
     }

    public int removeStone() // this method will return the number of stones in the last turn
    {
        if(upperBound < stones)
        {
            stones = upperBound;
        }
        else if (stones < upperBound)
        {
            stones = stones -1;
        }
       if (stones < 1)
       {
           stones = 1;
       }
       return stones;
    }
	
    public String advancedMove(boolean[] available, String lastMove) {
            // the implementation of the victory
            // guaranteed strategy designed by you
            String move = "";

            return move;
    }
}
