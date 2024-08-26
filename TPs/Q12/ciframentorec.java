/**
 * Gabriel Xavier Borges - 805347 - Q12
 */

class ciframentorec
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
     * Funcao recursiva para montar string Cifrada
     * @param string, int
     * @return string
     */
    public static String cifra (String str, int i)
    {
        String cifra = "";
        if(i < str.length())
        {
            cifra += (char)((str.charAt(i)) + 3);
            cifra += cifra(str, i + 1);
        }
        return cifra;
    }

    /**
     * Funcao auxiliar para chamar funcao cifra(str, i);
     * @param string
     * @return string 
     */
    public static String cifra (String str)
    {
        return cifra(str, 0);
    }



    /**
     * Funcao principal
     * @param args
     */
    public static void main (String args [])
    {
        String str = MyIO.readLine("");
        String strcifra;
        do
        {
            strcifra = cifra(str);
            MyIO.println(strcifra);
            str = MyIO.readLine("");
        }while(!isEnd(str));
    }

}