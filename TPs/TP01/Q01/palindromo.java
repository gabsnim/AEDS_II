/*
 * Gabriel Xavier Borges - 805347 - Q01
 * Versao melhorada
 */


class palindromo
{   
    /*
     * Funcao para verificar condicao de parada
     * @param string
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

    /*
     * Funcao para verificar se e palindromo
     * @param string
     * @return boolean 
    */
    public static boolean isPalindromo (String str)
    {
        int j = str.length() - 1;
        boolean resp = true;
        for(int i = 0; i < str.length()/2; i++)
        {
            //System.out.println(""+str.charAt(i) + str.charAt(j));
            if(str.charAt(i) != str.charAt(j))
            {
                resp = false;
                i = str.length()/2;
            }
            j--;
        }
        return resp;
    }

    /**
     * Funcao principal
     * @param agrs
    */
    public static void main (String[] agrs)
    {   
        MyIO.setCharset("UTF-8"); //setCharset pois o padrao nao identifica alguns caracteres
        //US-ASCII funciona

        String str;
        str = MyIO.readLine("");

        do
        {
            if(isPalindromo(str))
            {
                System.out.println("SIM");
            }
            else
            {
                System.out.println("NAO");
            }
            str = MyIO.readLine("");
        }while(!isEnd(str));
    }
}
