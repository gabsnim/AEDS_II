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
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        int x = 0, y = 0;
        x = scanner.nextInt();
        y = scanner.nextInt();
        System.out.println("----------------");
        print(x, y);
    }


}
