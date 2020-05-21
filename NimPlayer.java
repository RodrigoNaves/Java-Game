/*
 * This code is part of assignment 3 for Programming and Software Development COMP90041
 * As part of the University of Melbourne. May 2020
 * Written by Rodrigo Naves Vargas Student ID: 1092880
 */

import java.io.Serializable;
public abstract class NimPlayer implements Serializable
{
    private String playerName;
    private String playerLastName;
    protected int stones;
    private String username;
    private int gamesPlayed;
    private int totalScore;
    private double ranking;
    protected String stoneString;
    protected int upperBound;
    //static NimPlayer[] playersInSystem = new NimPlayer[100];
    
    /*constructors*/
    NimPlayer(String username, String lastName ,String firstName)
    {
        playerName = firstName ;
        playerLastName = lastName;
        this.username = username;
        totalScore = 0;
        gamesPlayed = 0;
    }
    
    /*Accesors*/
    
    public String getuserName() // this method will return the name of the player
    {
        return username;
    }
    public String getLastName() // this method will return the last name of the player
    {
        return playerLastName;
    }
    public String getFirstName() // this method will return the first name of the player
    {
        return playerName;
    }
    public String getName() // this method will return the name of the player
    {
        return playerName + " " + playerLastName;
    }
    public String displayPlayer()
    {
        return username +","+playerName+","+playerLastName+","+gamesPlayed+" games,"+totalScore+" wins";
    }
    public int getGamesPlayed()
    {
        return gamesPlayed;
    }
    public int getScore()
    {
        return totalScore;
    }
    public double getRanking()
    {
        calcRanking();
        return ranking*100;
    }
    /*Mutators*/
    public void calcRanking()
    {
        if (gamesPlayed == 0)
        {
            ranking = 0;
        }
        else
        {
            ranking = (double) totalScore/gamesPlayed;   
        }

    }
    
    public void deletePlayer()
    {
        playerName = null;
        playerLastName = null;
        username = null;
        totalScore =  0;
        gamesPlayed = 0;
    }
    public void editPlayer( String lastName,String firstName, String username)
    {
        playerLastName = lastName;
        playerName = firstName ;
        this.username = username;
    }
    public void editPlayer(String lastName, String firstName)
    {
        playerLastName = lastName;
        playerName = firstName ;
    }
    public void editPlayer(String firstName)
    {
        playerName = firstName ;
    }
    public void resetStatistics()
    {
        totalScore = 0;
        gamesPlayed = 0;  
    }
    public void addGamesPlayed()
    {
        gamesPlayed ++;
    }
    public void addScore()
    {
        totalScore ++;
    }
    public void setParamRemoveStone(int upperBound, int stones)
    {
        this.upperBound = upperBound;
        this.stones = stones;
    }
    public abstract int removeStone(); // this method will return the number of stones in the last turn
}
