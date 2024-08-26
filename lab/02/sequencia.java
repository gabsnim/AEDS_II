/**
 * Gabriel Xavier Borges - 805347 - Lab02
 */

import java.util.*;

class sequencia
{
    public static void print(int x, int y)
    {
        for(int i = x; i <= y; i++)
        {
            System.out.print(""+ i);
        }

        while(y >= x)
        {
            String str = String.valueOf(y);
            
            for(int i = str.length() - 1; i >= 0; i--)
            {
                System.out.print(""+ str.charAt(i));
            }
            y--;
        }
        System.out.println("");
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner (System.in);
        int x, y;
        
        while(scan.hasNextInt())
        {
            x = scan.nextInt();
            y = scan.nextInt();
            print(x, y);
        }

        scan.close();
    }
}
