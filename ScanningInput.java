/*
 * This code is part of assignment 3 for Programming and Software Development COMP90041
 * As part of the University of Melbourne. May 2020
 * Written by Rodrigo Naves Vargas Student ID: 1092880
 */


import java.util.Scanner;
public class ScanningInput {
    static Scanner ScanningInput = new Scanner(System.in);
    
    public static String ScanningInput()
    {
        return ScanningInput.next();
    }
    
    public static String nextLine()
    {
        return ScanningInput.nextLine();
    }
    
    public static int nextInt()
    {
        return ScanningInput.nextInt();
    }
    public static void reset()
    {
        ScanningInput.reset();
    }
    public static boolean hasNextInt()
    {
       return ScanningInput.hasNextInt();
    }
}
