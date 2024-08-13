import java.util.Scanner;



public class recursivo
{

    public static boolean isEnd (String str)
    {
        boolean r = false;
        if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')
        {
            r = true;
        }
        return r;
    }

    public static boolean isUpper (char c)
    {
        boolean r = false;
        if(c >= 'A' && c <= 'Z')
        {
            r = true;
        }
        return r;
    }

    public static int isCount (String str, int index)
    {   
        int x = 0;
        if(index < str.length())
        {
            if(isUpper(str.charAt(index)))
            {
                return x =  1 + isCount(str, index + 1);
            }
            isCount(str, index + 1);
        }
        return x;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        String str = scanner.nextLine();
        do
        {
            int resp = isCount(str, 0);
            System.out.println(""+resp);
            str = scanner.nextLine();
        }while(!isEnd(str));
    }
    
}
