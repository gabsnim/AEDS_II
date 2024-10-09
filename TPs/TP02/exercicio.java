/**
 * Gabriel Xavier Borges - 805347
 * Q01 - TP02
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

class Pokemon
{
    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList <String> types;
    private ArrayList <String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private Boolean isLegendary;
    private Date captureDate;

    public Pokemon()
    {   
        this.id = 0;
        this.generation = 0;
        this.name = " ";
        this.description = " ";
        this.types = new ArrayList<String> (); 
        this.abilities = new ArrayList<String> ();
        this.weight = 10.0;
        this.height = 10.0;
        this.captureRate = 100;
        this.isLegendary = true;
        this.captureDate = new Date();
    }

    public Pokemon(int id, int generation, String name, String description, ArrayList<String> types, ArrayList<String> abilities, double weight, double  height, int captureRate, Boolean isLegendary, Date captureDate)
    {
    this.id = id;
    this.generation = generation;
    this.name = name;
    this.description = description;
    this.types = new ArrayList<>(); 
    this.abilities = new ArrayList<>(); 
    this.weight = weight;
    this.height = height;
    this.captureRate = captureRate;
    this.isLegendary = isLegendary;
    this.captureDate = captureDate;
    }

    public int getId(){return id;}

    public int getGeneration(){return generation;}

    public String getName(){return name;}

    public String getDescription(){return description;}

    public ArrayList<String> getTypes(){return this.types;}

    public ArrayList<String> getAbilities(){return this.abilities;}

    public double getWeight (){return this.weight;}
    
    public double getHeight (){return this.height;}

    public int getCaptureRate (){return this.captureRate;}

    public Boolean getIsLegendary (){return this.isLegendary;}

    public Date getCaptureDate (){return this.captureDate;}
    
    /* gets 🖢 ============================================ sets 🖣*/

    public void setId(int id) {this.id = id;}

    public void setGeneration(int generation){this.generation = generation;}

    public void setName(String name){this.name = name;}

    public void setDescription(String description){this.description = description;}   

    public void setTypes(String types){this.types.add(types); }

    public void setAbilities(ArrayList<String> abilities){this.abilities = abilities;  }

    public void setWeight (double weight){this.weight = weight;}
    
    public void setHeight (double height){this.height = height;}

    public void setCaptureRate (int captureRate){this.captureRate = captureRate;}

    public void setIsLegendary (Boolean isLegendary){this.isLegendary = isLegendary;}

    public void setCaptureDate (Date captureDate){this.captureDate = captureDate;}

    /* ================================================ */


    /**
     * Funcao para ler do arquivo csv e retonar uma string com o conteudo
     */
    public static String readCsv ()
    {
        String filePath = "/tmp/pokemon.csv"; //caminho verde
        // String filePath = "/home/gabs/faculdade/AEDS_II/TPs/TP02/pokemon.csv";
        String linha;
        StringBuilder csv = new StringBuilder();


        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            br.readLine();
            while ((linha = br.readLine()) != null)
            {
                csv.append(linha).append("\n");
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String resultado = csv.toString();

        return resultado;
    }


    /**
     * Cortar as habilidades para facilitar a manipulacao
     */
    public static String[] splitAbilities (String str)    //cortar habilidades e retonar num array de String 
    {
        String aux = "";
        for (int i = 0; i < str.length(); i++) 
        {
            if (str.charAt(i) == '[')
            {
                for (int j = i + 1; str.charAt(j) != ']'; j++)
                {
                    aux += str.charAt(j); 
                }
            }
        }
        String[] abilities = aux.split(",(?=(?:[^\\[\\]]*\\[[^\\[\\]]*\\])*[^\\[\\]]*$)");
        return abilities;
    }

    /**
     * Setar os pokemons
     */
    public static Pokemon[] setPokemons (String str)
    {
        String [] lines = str.split("\n");  //linhas do csv
  
        Pokemon[] list = new Pokemon[801];  //array de pokemnos

        for(int i = 0; i < 801; i++)
        {

            String[] abilities = splitAbilities(lines[i]);  //array de habilidades

            String [] values = lines[i].split(",");
            
            for(int x = 0; x < values.length; x++)
            {
                String aux = "0";
                if(values[x].isEmpty())
                {
                    values[x] = aux;
                }
            
            }

            list[i] = new Pokemon();

            list[i].setId(Integer.parseInt(values[0]));

            list[i].setGeneration(Integer.parseInt(values[1]));
           
            list[i].setName(values[2]);
            
            list[i].setDescription(values[3]);
           
            list[i].setTypes(values[4]);
            
            list[i].setTypes(values[5]);
          

            for(int j = 0; j < abilities.length; j++)
            {
                list[i].abilities.add(abilities[j]);
            }
      
            int y = abilities.length+1;
 
            list[i].setWeight(Double.parseDouble(values[5+y]));

            list[i].setHeight(Double.parseDouble(values[6+y]));
 
            list[i].setCaptureRate(Integer.parseInt(values[7+y]));
            
            if (values[8+y].equals("1"))
            {
                list[i].setIsLegendary(true);
            }
            else
            {
               list[i].setIsLegendary(false);
            }

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            
            try 
            {
                Date date = format.parse(values[9+y]);
                list[i].setCaptureDate(date);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        return list;
    }

    public Pokemon clone()
    {
        try
        {
            return (Pokemon) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println("Cloning not supported.");
            return null;
        }
    }

    public String printAbilities(Pokemon p)
    {
        StringBuilder abilitiesStr = new StringBuilder();
            
            for (int i = 0; i < p.getAbilities().size(); i++)
            {
                abilitiesStr.append(p.getAbilities().get(i));
                
                if (i < p.getAbilities().size() - 1)
                {
                    abilitiesStr.append(", ");
                }
            }
            
        return abilitiesStr.toString();
    }   

    public String printTypes(Pokemon p)
    {
        StringBuilder typesStr = new StringBuilder();
    
        for (int i = 0; i < p.getTypes().size(); i++)
        {
            typesStr.append("'").append(p.getTypes().get(i)).append("'");  
            if (i < p.getTypes().size() - 1)
            {
                typesStr.append(", ");  
            }
        }
    
        return typesStr.toString();  
    }

    public void printPokemons(Pokemon p)
    {
        String a = printAbilities(p);
        String b = printTypes(p);

        if (p.getTypes().size() > 1 && p.getTypes().get(1).equals("0")) {  //verifica se existe o segundo tipo e se ele e "0"
            System.out.println(
                String.format(
                    "[#%d -> %s: %s - ['%s'] - [%s] - %.1fkg - %.1fm - %d%% - %b - %d gen] - %td/%tm/%tY",
                    p.getId(),                     
                    p.getName(),                   
                    p.getDescription(),            
                    p.getTypes().get(0),            
                    a,                              
                    p.getWeight(),                 
                    p.getHeight(),                  
                    p.getCaptureRate(),            
                    p.getIsLegendary(),             
                    p.getGeneration(),              
                    p.getCaptureDate(),           
                    p.getCaptureDate(),             
                    p.getCaptureDate()              
                )
            );
        }
        else
        {
            System.out.println(
                String.format(
                    "[#%d -> %s: %s - [%s] - [%s] - %.1fkg - %.1fm - %d%% - %b - %d gen] - %td/%tm/%tY",
                    p.getId(),                      
                    p.getName(),                    
                    p.getDescription(),            
                    b,                              
                    a,                              
                    p.getWeight(),                 
                    p.getHeight(),                  
                    p.getCaptureRate(),           
                    p.getIsLegendary(),            
                    p.getGeneration(),              
                    p.getCaptureDate(),             
                    p.getCaptureDate(),             
                    p.getCaptureDate()              
                )
            );
        }
    }

}

class exercicio extends Pokemon
{   

    public ArrayList<Pokemon> Q01 (Pokemon [] pokemons, int id)
    {
        ArrayList<Pokemon> lista = new ArrayList<>();

        lista.add(pokemons[id - 1]);

        return lista;
    }

    public static boolean isEnd(String str)
    {
        boolean r = false;
        if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M')
        {
            r = true;
        }
        return r;
    }

    public static void main (String[] args)
    {
        String a = readCsv();   

        Pokemon[] pokemons = Pokemon.setPokemons(a);                                

        Pokemon p = new Pokemon();                                                  

        Scanner scan = new Scanner(System.in);

        ArrayList<Pokemon> listaVerde = new ArrayList<>();

        String id = scan.nextLine();

        do
        {
            listaVerde.add(pokemons[Integer.parseInt(id) - 1]);

            id = scan.nextLine();

        }while(!isEnd(id));

        for(int i = 0; i < listaVerde.size(); i++)
        {
            p.printPokemons(listaVerde.get(i));
        }
    }
}