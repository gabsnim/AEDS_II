import java.util.ArrayList;
import java.util.*;
import javax.print.DocFlavor;
class teste
{
    private int id;
    private ArrayList <String> nomes;

    teste()
    {
        this.id = 0;
        this.nomes = new ArrayList<String> ();
    }

    public void setNomes(String a)
    {
        this.nomes.add(a);
    }

    public void print()
    {
        System.out.println(this.id);
        for(String xd: nomes)
        {
            System.out.println(xd);
        }
    }

    public static void main (String[] args)
    {
        teste xd = new teste ();
        xd.setNomes("abc");
        xd.setNomes("def");
        xd.print();

        Scanner scan = new Scanner(System.in);

        String a = scan.nextLine();
        String b = "";

        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) == '[')
            {
                for(int j = i+1; a.charAt(j) != ']'; j++)
                {
                    if(a.charAt(j) != ' ')
                    {
                        b += a.charAt(j);
                    }
                }
            }
        }
        System.out.println(b);

        
    }

}