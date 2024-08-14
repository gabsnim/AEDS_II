public class palindromorecursivo
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

    public static boolean isPalindromo (String str, int i)
    {
        boolean r;

            if(str.length() == 1)
            {
                r = true;
            }
            else if(str.charAt(i) == str.charAt(str.length() - 1 - i))
            {
                r = isPalindromo(str, i + 1);
            }
            else
            {
                r = false;
            }

        return r;
    }

    public static void main (String[] args)
    {
        MyIO.setCharset("US-ASCII");
        
        String str;
        str = MyIO.readLine("");

        do 
        { 
            if(isPalindromo(str, 0))
            {
                MyIO.println("SIM");
            }
            else
            {
                MyIO.println("NAO");
            }
            str = MyIO.readLine("");
        }while (!isEnd(str));
    }
}
