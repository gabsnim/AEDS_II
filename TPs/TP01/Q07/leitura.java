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
        int valores[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\u0061') {
                valores[0] = valores[0] + 1;
            } else if (str.charAt(i) == '\u0065') {
                valores[1] = valores[1] + 1;
            } else if (str.charAt(i) == '\u0069') {
                valores[2] = valores[2] + 1;
            } else if (str.charAt(i) == '\u006F') {
                valores[3] = valores[3] + 1;
            } else if (str.charAt(i) == '\u0075') {
                valores[4] = valores[4] + 1;
            } else if (str.charAt(i) == '\u00E1') {
                valores[5] = valores[5] + 1;
            } else if (str.charAt(i) == '\u00E9') {
                valores[6] = valores[6] + 1;
            } else if (str.charAt(i) == '\u00ED') {
                valores[7] = valores[7] + 1;
            } else if (str.charAt(i) == '\u00F3') {
                valores[8] = valores[8] + 1;
            } else if (str.charAt(i) == '\u00FA') {
                valores[9] = valores[9] + 1;
            } else if (str.charAt(i) == '\u00E0') {
                valores[10] = valores[10] + 1;
            } else if (str.charAt(i) == '\u00E8') {
                valores[11] = valores[11] + 1;
            } else if (str.charAt(i) == '\u00EC') {
                valores[12] = valores[12] + 1;
            } else if (str.charAt(i) == '\u00F2') {
                valores[13] = valores[13] + 1;
            } else if (str.charAt(i) == '\u00F9') {
                valores[14] = valores[14] + 1;
            } else if (str.charAt(i) == '\u00E3') {
                valores[15] = valores[15] + 1;
            } else if (str.charAt(i) == '\u00F5') {
                valores[16] = valores[16] + 1;
            } else if (str.charAt(i) == '\u00E2') {
                valores[17] = valores[17] + 1;
            } else if (str.charAt(i) == '\u00EA') {
                valores[18] = valores[18] + 1;
            } else if (str.charAt(i) == '\u00EE') {
                valores[19] = valores[19] + 1;
            } else if (str.charAt(i) == '\u00F4') {
                valores[20] = valores[20] + 1;
            } else if (str.charAt(i) == '\u00FB') {
                valores[21] = valores[21] + 1;
            } else if (str.charAt(i) >= 97 && str.charAt(i) <= 122 && str.charAt(i) != '\u0061'
                    && str.charAt(i) != '\u0065'
                    && str.charAt(i) != '\u0069' && str.charAt(i) != '\u006F' && str.charAt(i) != '\u0075') {
                valores[22] = valores[22] + 1;
            }

        }
        return valores;
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

    public static char[] setarEspeciais ()
    {
        char[] array = {
            (char) 225, (char) 233, (char) 237, (char) 243, (char) 250, 
            (char) 224, (char) 232, (char) 236, (char) 242, (char) 249, 
            (char) 227, (char) 245, (char) 226, (char) 234, (char) 238, 
            (char) 244, (char) 251
        };
        return array;
    }

    /**
     * Funcao principal
     * @param String [] args
     */
	public static void main(String[] args)
    {   
        //<clean html?>
        
        MyIO.setCharset("UTF-8");
        
        char[] array = setarEspeciais();

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
                System.out.printf("%c(%s) ",array[0] , vogais[5]); //setar caracteres especiais 
                System.out.printf("%c(%s) ",array[1] , vogais[6]);
                System.out.printf("%c(%s) ",array[2] , vogais[7]);
                System.out.printf("%c(%s) ",array[3], vogais[8]);
                System.out.printf("%c(%s) ",array[4], vogais[9]);
                System.out.printf("%c(%s) ",array[5], vogais[10]);
                System.out.printf("%c(%s) ",array[6], vogais[11]);
                System.out.printf("%c(%s) ",array[7], vogais[12]);
                System.out.printf("%c(%s) ",array[8], vogais[13]);
                System.out.printf("%c(%s) ",array[9], vogais[14]);
                System.out.printf("%c(%s) ",array[10], vogais[15]);
                System.out.printf("%c(%s) ",array[11], vogais[16]);
                System.out.printf("%c(%s) ",array[12], vogais[17]);
                System.out.printf("%c(%s) ",array[13], vogais[18]);
                System.out.printf("%c(%s) ",array[14], vogais[19]);
                System.out.printf("%c(%s) ",array[15], vogais[20]);
                System.out.printf("%c(%s) ",array[16], vogais[21]);
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