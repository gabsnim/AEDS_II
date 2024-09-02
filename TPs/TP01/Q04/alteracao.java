import java.util.Random;

/**
 * Gabriel Xavier Borges - 805347 - Q04
 */

public class alteracao 
{

    /**
     * Funcao para verificar condicao de parada
     * @param string
     * @return boolean
     */
    public static boolean isEnd(String str)
    {
        boolean r = false;
        if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')
        {
            r = true;
        }
        return r;
    }

    /**
     * Funcao para modificar a string para alteracaoAleatoria
     * @param string
     * @return string modificada
     */
    public static String alteracaoAleatoria(String str, Random gerador)
    {
        //System.out.println(""+c +z);

        char c = (char)(97 + (Math.abs(gerador.nextInt()) % 26));
        char z = (char)(97 + (Math.abs(gerador.nextInt()) % 26));
        String nova = "";

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != c)
            {
                nova = nova + str.charAt(i);
            }
            else
            {
                nova = nova + z;
                
            }
        }
        return nova;
    }

    /** 
     * Funcao principal
     * @param args
     */
    public static void main (String[] args)
    {
        MyIO.setCharset("UTF-8");
        Random gerador = new Random();
        gerador.setSeed(4);

        String str = MyIO.readLine();
        do
        {
            System.out.println(""+alteracaoAleatoria(str, gerador));
            str = MyIO.readLine();
        }while(!isEnd(str));
    }
}
