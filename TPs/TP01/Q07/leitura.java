/**
 * Gabriel Xavier Borges - 805347 - Q07
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class leitura
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

    /**
     * Funcao inteira para contar consoantes na pagina
     * @param String (conteudo da pag)
     * @return int 
     */
    public static int countConsoantes(String str)
    {
        String aux = "bcdfghjklmnpqrstvwxyz";
        int count = 0;
        char c;
        for(int i = 0; i < str.length(); i++)
        {
            c = str.charAt(i);
            if(aux.indexOf(c) != -1)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Funcao inteira para contar tag <table> na pagina
     * @param String (conteudo da pag)
     * @return int 
     */
    public static int countTable(String str)
    {
        String aux = "<table>";
        int count = 0;
        int i = 0;

        while((i = str.indexOf(aux, i)) != -1)
        {
            count++;
            i += aux.length();
        }
        return count;
    }

    /**
     * Funcao inteira para contar tag <br> na pagina
     * @param String (conteudo da pag)
     * @return int 
     */
    public static int countBr(String str)
    {
        String aux = "<br>";
        int count = 0;
        int i = 0;

        while ((i = str.indexOf(aux, i)) != -1)
        {
            count++;
            i += aux.length();
        }
        return count;
    }

    /**
     * Funcao inteira [] para contar vogais(e vogais especiais) e guardar num array 
     * @param String (conteudo da pag)
     * @return int[] (array para guardar o contador de vogais)
     */
    public static int[] countVogais(String str)
    {
        String aux = "aeiouáéíóúàèìòùãõâêîôû";
        int[] count = new int[aux.length()];
        char c;
        int n;

        for(int i = 0; i < str.length(); i++)
        {
            c = str.charAt(i);
            n = aux.indexOf(c);
            if(n != -1)
            {
                count[n]++;
            }

        }
        return count;
    }


    /**
     * Funcao para obter o texto de uma pagina html
     * @param String
     * @return String (texto)
     */
	public static String getHtml(String endereco)
    {
		StringBuffer resp = new StringBuffer();
		try {
			URL obj = new URL(endereco);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// Método de requisição
			con.setRequestMethod("GET");

			// Código de resposta da conexão
			int responseCode = con.getResponseCode();
			//System.out.println("Código de resposta: " + responseCode);

			// Se a conexão foi bem-sucedida (código 200)
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					resp.append(inputLine);
				}

				// Fecha os buffers
				in.close();

			} else {
				System.out.println("Erro na conexão: " + responseCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}      

		return resp.toString();
	}


    /**
     * Funcao principal
     * @param String [] args
     */
	public static void main(String[] args)
    {   
        //<clean html?>
        
        MyIO.setCharset("UTF-8");
		String endereco, nome;

       // nome = MyIO.readLine();
       // endereco = MyIO.readLine();

        do
        {
            nome = MyIO.readLine();
            if(!isEnd(nome))
            {
                endereco = MyIO.readLine();
                String str = getHtml(endereco);

                int[] vogais = countVogais(str);
                int consoantes = countConsoantes(str);
                int countbr = countBr(str);
                int counttable = countTable(str);

                vogais[0] = vogais[0] - counttable;
                System.out.printf("a(%s) ", vogais[0]);
                vogais[1] = vogais[1] - counttable;
                System.out.printf("e(%s) ", vogais[1]);
                System.out.printf("i(%s) ", vogais[2]);
                System.out.printf("o(%s) ", vogais[3]);
                System.out.printf("u(%s) ", vogais[4]);
                System.out.printf("%s(%s) ", (char)225, vogais[5]); //setar caracteres especiais 
                System.out.printf("%s(%s) ", (char)233, vogais[6]);
                System.out.printf("%s(%s) ", (char)237, vogais[7]);
                System.out.printf("%s(%s) ", (char)243, vogais[8]);
                System.out.printf("%s(%s) ", (char)250, vogais[9]);
                System.out.printf("%s(%s) ", (char)224, vogais[10]);
                System.out.printf("%s(%s) ", (char)232, vogais[11]);
                System.out.printf("%s(%s) ", (char)236, vogais[12]);
                System.out.printf("%s(%s) ", (char)242, vogais[13]);
                System.out.printf("%s(%s) ", (char)249, vogais[14]);
                System.out.printf("%s(%s) ", (char)227, vogais[15]);
                System.out.printf("%s(%s) ", (char)245, vogais[16]);
                System.out.printf("%s(%s) ", (char)226, vogais[17]);
                System.out.printf("%s(%s) ", (char)234, vogais[18]);
                System.out.printf("%s(%s) ", (char)238, vogais[19]);
                System.out.printf("%s(%s) ", (char)244, vogais[20]);
                System.out.printf("%s(%s) ", (char)251, vogais[21]);
                consoantes = consoantes - ((2*countbr) + 3*counttable);
                System.out.printf("consoante(%s) ", consoantes);
                System.out.printf("<br>(%s) ", countbr);
                System.out.printf("<table>(%s) ", counttable);
                System.out.printf("%s\n", nome);
            }
            //nome = MyIO.readLine();
        }while(!isEnd(nome));
	}
}