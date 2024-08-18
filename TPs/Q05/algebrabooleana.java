class algebrabooleana
{


    public static boolean isDigit (char c)
    {
        if(c >= '0' & c <= '9')
        {
            return true;
        }
        return false;  
    }

    public static boolean isUpper (char c)
    {
        if(c >= 'A' & c <= 'Z')
        {
            return true;
        }
        return false;
    }

    public static String aux1 (String str) //separar expressao dos valores das variaveis;
    {
        String nova = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(!isDigit(str.charAt(i)) & str.charAt(i) != ' ')
            {
                nova = nova + (char)(str.charAt(i));
            }
        }
        return nova;   
    }

    public static void main (String[] args)
    {
        String line;
        line = MyIO.readLine();
        System.out.println(""+aux1(line));
    }
}