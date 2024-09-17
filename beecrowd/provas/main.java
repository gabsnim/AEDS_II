/**
 * Gabriel Xavier Borges - 805347
 * Prova pratica 01 - linguagem Java
*/

class main
{

    /**
     * Funcao para verificar se existe tal caracter na string (alfabeto)
     * @param str
     * @param c
     * @return
     */
    public static boolean contem (String str, char c)
    {
        boolean r = false;
        for(int i = 0; i < str.length(); i++)
        {
            if(c == str.charAt(i))
            {
                r  = true;
                i = str.length();
            }
        }
        return r;
    }

    public static void main (String[] args)
    {
        int k, n; //k numero de caracteres alfabeto
        k = MyIO.readInt();
        n = MyIO.readInt();
        int count = 0;
        //MyIO.setCharset("utf-8");
        String alien = MyIO.readString();//alfabeto
        String msg = MyIO.readString();//mensagem

        for(int i = 0; i < n; i++)
        {
            if(contem(alien, msg.charAt(i)))
            {
                count++;
            }
        }

        if(count != n) //ou seja, nem todos caracteres faziam parte do alfabeto
        {
            System.out.println("N");
        }
        else
        {
            System.out.println("S");
        }
    }
}