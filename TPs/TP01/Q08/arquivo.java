import java.io.RandomAccessFile;

/**
 * Gabriel Xavier Borges - 805347 - Q08
 */

class arquivo
{
    /**
     * Metodo para escrever numeros no arquivo binario 
     * @param String filename
     * @param int n
     */
    public static void writeFile (String filename, int n)
    {
        double y = 0.0;
        try
        {
            RandomAccessFile arquivo = new RandomAccessFile(filename, "rw");

            for(int i = 0; i < n; i++)
            {
                y = MyIO.readDouble();
                arquivo.writeDouble(y);
            }
            arquivo.close();
        }
        catch( Exception e)
        {
            System.out.println(""+ e.getMessage());
        }
    }

    /**
     * Metodo para ler numeros do arquivo binario
     * @param String filename
     * @param int n
     */
    public static void readFile (String filename, int n)
    {
        double y = 0.0;
        try
        {
            RandomAccessFile arquivo = new RandomAccessFile(filename, "rw");
            int pointer = (int)arquivo.length();

            for(int i = 0; i < n; i++)
            {
                pointer -= 8;
                arquivo.seek(pointer);
                y = arquivo.readDouble();
                if(y == (int)y)
                {
                    MyIO.println(""+(int)y);
                }
                else
                {
                    MyIO.println(""+y);
                }
            }
            arquivo.close();
        }
        catch(Exception e)
        {
            System.out.println(""+e.getMessage());
        }
    }

    /**
     * Funcao principal
     * @param String [] args
     */
    public static void main (String [] args)
    {
        int n = MyIO.readInt("");
        String filename = "dados.txt";

        writeFile(filename, n);

        readFile(filename, n);
    }
}