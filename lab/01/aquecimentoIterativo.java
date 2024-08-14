/**
 * Gabriel Xavier Borges - 805347 - Aquecimento01 - 13/08
 */

public class aquecimentoIterativo 
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
     * Funcao para verificar se o caracter e maiusculo
     * @param c
     * @return boolean
     */
    public static boolean isUpper (char c)
    {
        boolean r = false;
        if(c >= 'A' && c <= 'Z')
        {
            r = true;
        }
        return r;
    }

    /**
     * Funcao para contar letras maiusculas na string
     * @param str
     * @return int
     */
    public static int countUpper (String str)
    {
        int n = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if(isUpper(str.charAt(i)))
            {
                n = n + 1;
            }
        }
        return n;
    }

    /**
     * Funcao principal
     * @param agrs
     */
    public static void main (String[] agrs)
    {
        String str;
        str = MyIO.readLine();

        do
        {
            System.out.println(""+(countUpper(str)));

            str = MyIO.readLine();
        }while(!isEnd(str));
    }
}
