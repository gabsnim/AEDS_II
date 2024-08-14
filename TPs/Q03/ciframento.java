
class ciframento
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

    public static void cifra (String str)
    {
        char[] arraystr = new char[80];
        for(int i = 0; i < str.length(); i++)
        {
            arraystr[i] = str.charAt(i);
            arraystr[i] = (char) (arraystr[i] + 3);
        }
        for(int i = 0; i < str.length(); i++)
        {
            System.out.print(""+arraystr[i]);
        }
        System.out.println("");
    }

    public static void main (String args [])
    {

        MyIO.setCharset("UTF-8"); 
        String str = MyIO.readString("");
        
        do
        {
            cifra(str);
            str = MyIO.readString("");
        }while(!isEnd(str));
    }

}