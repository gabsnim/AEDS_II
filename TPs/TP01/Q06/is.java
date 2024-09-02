class aux
{
    public static boolean isVogal (char c)
    {
        boolean r = false;
        Character.toLowerCase(c);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){r = true;}
        return r;
    }

    public static boolean isConsoante (char c)
    {
        boolean r = false;
        c = Character.toLowerCase(c);
        if(!isVogal(c) && !isDigit(c) && !isPonto(c)){r = true;}
        return r;
    }

    public static boolean isDigit(char c)
    {
        boolean r = false;  
        if(c >= '0' && c <= '9'){r = true;}
        return r;
    }

    public static boolean isPonto(char c)
    {
        boolean r = false;
        if(c == '.' || c == ','){r = true;}
        return r;
    }
}

class is
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
     * Funcao para verificar se na string so existem vogais
     * @param string
     * @return boolean
     */
    public static boolean isVogal (String str)
    {
        boolean r = true;
        
        for(int i = 0; i < str.length(); i++)
        {
            if(!aux.isVogal(str.charAt(i)))
            {
                r = false;
                i = str.length();
            }
        }
        return r;
    }

    /**
     * Funcao para verificar se na string so existem consoantes
     * @param string
     * @return boolean
     */
    public static boolean isConsoante (String str)
    {
        boolean r = false;
        
        for(int i = 0; i < str.length(); i++)
        {
            if(!aux.isConsoante(str.charAt(i)))
            {
                r = false;
                i = str.length();
            }
        }
        return r;
    }

    /**
     * Funcao para verificar se na string so existem inteiros
     * @param string
     * @return boolean
     */
    public static boolean isInt (String str)
    {
        boolean r = false;
        
        for(int i = 0; i < str.length(); i++)
        {
            if(!aux.isDigit(str.charAt(i)))
            {
                r = false;
                i = str.length();
            }
        }
        return r;
    }

    /**
     * Funcao para verificar se na string so existem reais
     * @param string
     * @return boolean
    */
    public static boolean isReal (String str)
    {
        boolean r = false;
        int temponto = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if(aux.isDigit(str.charAt(i)) || aux.isPonto(str.charAt(i)))
            {
                r = true;
                if(aux.isPonto(str.charAt(i)))
                {
                    temponto++;
                }
            }
            else
            {
                r = false;
                i = str.length();
            }
        }
        if(temponto == 1)
        {
            r = true;
        }
        else
        {
            r = false;
        }
        return r;
    }

    public static void main (String[] args)
    {
        String str = MyIO.readLine("");
        
        do
        {
            if(isVogal(str))
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }

            if(isConsoante(str))
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }


            if(isInt(str))
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }

            if(isReal(str))
            {
                System.out.println("SIM");
            }
            else
            {
                System.out.println("NAO");
            }

            //System.out.println("");

            str = MyIO.readLine();
        }while(!isEnd(str));
    }
}