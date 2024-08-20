class aux
{
    public static boolean isDigit(char c)
    {
        boolean r = false;  
        if(c >= '0' && c <= '9'){r = true;}
        return r;
    }

    public static boolean isPonto(char c)
    {
        boolean r = false;
        if(c == '.'){r = true;}
        return r;
    }
}

class isrec
{
    public static boolean isVogal (String str, int i)
    {
        boolean r = true;
        if(i < str.length())
        {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' || str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
            {
                r = isVogal(str, i+1);
            }
            else
            {
                r = false;
                return isVogal(str, i = str.length());
            }
        }
        return r;
    }

    public static boolean isVogal (String str)
    {
        return isVogal(str, 0);
    }

    public static boolean isReal (String str, int i)
    {
        boolean r = true;

        if(i < str.length() && aux.isDigit(str.charAt(0)))
        {
            if(aux.isDigit(str.charAt(i)) || aux.isPonto(str.charAt(i)))
            {
                return isReal(str, i + 1);
            }
            else
            {
                //r = false;
                return false;
            }
        }

        return r;
    }

    public static boolean isReal (String str)
    {
        return isReal(str, 1);
    }

    public static void main (String[] args)
    {
        System.out.println(""+isReal("123323a.4"));
    }

}