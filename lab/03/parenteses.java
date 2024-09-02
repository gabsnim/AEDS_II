/**
 * Gabriel Xavier Borges - 805347 - lab03
 */

class parenteses
{
    /*
     * Funcao para verificar condicao de parada
     * @param String
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
     * Funcao para verificar se os paranteses estao fechando corretamente
     * @param String
     * @return boolean
     */
    public static boolean verificar (String str)
    {
        boolean r = false;
        char c;
        int count = 0;

        for(int i = 0; i < str.length(); i++)
        {
            c = str.charAt(i);

            if(c == '(')
            {
                count++;
            }
            else if(c == ')')
            {
                count--;

                if(count < 0)
                {
                    return false;
                }
            }
        }

        return count == 0;
    }


    /**
     * Funcao principal
     * @param String[] args
     */
    public static void main(String[] args)
    {
        String str;

        str = MyIO.readLine();

        do
        {
            if(verificar(str))
            {
                System.out.println("correto");
            }
            else
            {
                System.out.println("incorreto");
            }
            str = MyIO.readLine();

        }while(!isEnd(str));
    }
}