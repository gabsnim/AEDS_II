import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
class Pokemon
{
    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private Date captureDate;

    public Pokemon()
    {   
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.weight = 0.0;
        this.height = 0.0;
        this.captureRate = 0;
        this.isLegendary = false;
        this.captureDate = new Date();
    }

    public Pokemon(int id, int generation, String name, String description, ArrayList<String> types, 
                   ArrayList<String> abilities, double weight, double height, int captureRate, 
                   boolean isLegendary, Date captureDate)
    {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getGeneration() { return generation; }
    public void setGeneration(int generation) { this.generation = generation; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ArrayList<String> getTypes() { return types; }
    public void setTypes(ArrayList<String> types) { this.types = types; }

    public ArrayList<String> getAbilities() { return abilities; }
    public void setAbilities(ArrayList<String> abilities) { this.abilities = abilities; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public int getCaptureRate() { return captureRate; }
    public void setCaptureRate(int captureRate) { this.captureRate = captureRate; }

    public boolean getIsLegendary() { return isLegendary; }
    public void setIsLegendary(boolean isLegendary) { this.isLegendary = isLegendary; }

    public Date getCaptureDate() { return captureDate; }
    public void setCaptureDate(Date captureDate) { this.captureDate = captureDate; }

    public static List<Pokemon> readAllFile(final String fileToRead)
    {
        List<Pokemon> pokemons = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileToRead)))
        {
            br.readLine();
        
            String csvLine;
            while((csvLine = br.readLine()) != null)
            {
                csvLine = lineFormat(csvLine);

                Pokemon pokemon = new Pokemon(csvLine.split(";"));
                pokemons.add(pokemon);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return pokemons;
    }

    public static String lineFormat(String line)
    {
        char[] array_aux = line.toCharArray();
        boolean in_list = false;
        for (int i = 0; i < array_aux.length; i++)
        {
            if (!in_list && array_aux[i] == ',') array_aux[i] = ';'; 
            else if (array_aux[i] == '"') in_list = !in_list;
        }

        return new String(array_aux);
    }

    public Pokemon(String[] aux) throws Exception
    {
        for (int i = 0; i < aux.length; i++) if (aux[i].isEmpty()) aux[i] = "0";

        this.id = Integer.parseInt(aux[0]);
        this.generation = Integer.parseInt(aux[1]);
        this.name = aux[2];
        this.description = aux[3];

        this.types = new ArrayList<>();
        aux[4] = "'" + aux[4] + "'";
        this.types.add(aux[4]);
        if (!aux[5].equals("0"))
        {
            aux[5] = "'" + aux[5].trim() + "'";
            this.types.add(aux[5]);  
        }

        aux[6] = aux[6].replace("\"", "").replace("[", "").replace("]", "");
        String[] tmp = aux[6].split(",");
        this.abilities = new ArrayList<>();
        for (String s : tmp) abilities.add(s.trim());

        this.weight = Double.parseDouble(aux[7]);
        this.height = Double.parseDouble(aux[8]);
        this.captureRate = Integer.parseInt(aux[9]);
        this.isLegendary = aux[10].equals("1");

        if (aux[11].isEmpty())
        {
            this.captureDate = null;
        }
        else
        {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            this.captureDate = inputDateFormat.parse(aux[11]);
        }
    }

    public String toString()
    {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = (captureDate != null) ? outputDateFormat.format(captureDate) : "Data não disponível";

        return "[#" + id + " -> " + name + ": " + description +
            " - " + types + " - " + abilities + 
            " - " + weight + "kg - " + height + "m - " +
            captureRate + "% - " + isLegendary + 
            " - " + generation + " gen] - " + formattedDate;
    }
}

class log
{
    private Instant start;
    private Instant end;
    private int comps;
    private int movs;

    log()
    {
        this.start = Instant.now(); 
        this.comps = 0; 
        this.movs = 0; 
    }

    public void comp()
    {
        this.comps++;
    }

    public void move()
    {
        this.movs++;
    }


    public void end()
    {
        this.end = Instant.now();
    }


    public double diff()
    {
        return Duration.between(this.start, this.end).toNanos() / 1_000_000_000.0;
    }


    public void print(String fileName) throws Exception 
    {
        try (PrintWriter write = new PrintWriter(new FileWriter(fileName)))
        {
            write.printf("Matrícula: 805347\t"); 
            write.printf("Tempo de execução: %.3f\t", diff()); 
            write.printf("Comparações: %d\t", comps);
            write.printf("Movimentações: %d", movs);
        }
    }
}

public class main
{
    public static void swap(List<Pokemon> array, int i, int j, log logger)
    {
        Pokemon temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
        logger.move(); logger.move(); logger.move();
    }

    public static void quickSortParcial(List<Pokemon> array, int left, int right, int k, log logger)
    {
        if (left < right) 
        {
            int pivo = partition(array, left, right, logger);

            if (pivo < k - 1)
            {
                quickSortParcial(array, left, pivo - 1, k, logger);
                quickSortParcial(array, pivo + 1, right, k, logger);
            } 
            else if (pivo == k - 1)
            {
                quickSortParcial(array, left, pivo - 1, k, logger);
            }
            else
            {
                quickSortParcial(array, left, pivo - 1, k, logger);
            }
        }
    }

    public static int partition(List<Pokemon> array, int left, int right, log logger)
    {
      Pokemon pivot = array.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) 
        {
            logger.comp();
            if (array.get(j).getGeneration() < pivot.getGeneration() || 
                (array.get(j).getGeneration() == pivot.getGeneration() && 
                array.get(j).getName().compareTo(pivot.getName()) <= 0))
            {
                i++;
                swap(array, i, j, logger);
            }
        }
        
        swap(array, i + 1, right, logger);

        return i + 1;
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        List<Pokemon> pokemons = Pokemon.readAllFile("/tmp/pokemon.csv");
        List<Pokemon> array = new ArrayList<>();

        String buffer = sc.nextLine();
        do 
        {
            array.add(pokemons.get(Integer.parseInt(buffer) - 1));
            buffer = sc.nextLine();
        }while(!buffer.equals("FIM"));

        log logger = new log();
        quickSortParcial(array, 0, array.size() - 1, 10, logger);

        logger.end();
        logger.print("805347_heapsortparcial.txt");

        for (int i = 0; i < 10; i++)
        {
            System.out.println(array.get(i));
        }

        sc.close();
    }

}
