/**
 * Gabriel Xavier Borges - 805347 - Aquecimento01 - 13/08
 */

public class aquecimentoRecursivo
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
     * Funcao para verificar se caracter e maiusculo
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
     * Funcao para inicializar o contador da funcao countUpper (index)
     * @param str
     * @return index
     */
    public static int countUpper (String str)
    {
        return countUpper(str, 0);
    }

    /**
     * Funcao recursiva para contar letras maiusculas na string
     * @param str
     * @param index
     * @return quantidade
     */
    public static int countUpper (String str, int index)
    {   
        int count = 0;
        if(index < str.length())
        {
            if(isUpper(str.charAt(index)))
            {
                count++;
            }
            count += countUpper(str, index + 1);
        }
        return count;
    }

    /**
     * Funcao principal
     * @param args
     */
    public static void main(String[] args)
    {        
        String str;
        str = MyIO.readLine("");
        do
        {
            System.out.println(""+countUpper(str));
            str = MyIO.readLine("");
        }while(!isEnd(str));
    }
    
}
