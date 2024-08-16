/**
 * Gabriel Xavier Borges - 805347 - Q03
 */

class ciframento
{
    /**
     * Funcao para verificar condicao de parada
     * @param str
     * @return boolean
     */
    public static boolean isEnd (String str)
    {
        boolean r = false;
        if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')
        {
            r = true;
        }
        return r;
    }
    
    /**
     * Funcao para montar string Cifrada
     * @param string
     */
    public static void cifra (String str)
    {
        char c;
        String cifra = "";
        for(int i = 0; i < str.length(); i++)
        {
            c = (char)(str.charAt(i) + 3);
            cifra = cifra + c;
        }
        System.out.println(""+cifra);
    }


    /**
     * Funcao principal
     * @param args
     */
    public static void main (String args [])
    {
        String str = MyIO.readLine("");
        
        do
        {
            cifra(str);
            str = MyIO.readLine("");
        }while(!isEnd(str));
    }

}