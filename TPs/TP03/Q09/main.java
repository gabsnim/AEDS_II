import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

class main
{
    public static void main(String[] args)
    {
        LinkedList lista = new LinkedList();
        LinkedList array = new LinkedList();
        // Pokemon.readAllFile("/home/gabs/faculdade/AEDS_II/TPs/TP03/pokemon.csv", lista);
        Pokemon.readAllFile("/tmp/pokemon.csv", lista);

        Scanner scan = new Scanner(System.in);
        String buffer = scan.nextLine();

        do
        {
            int pos = Integer.parseInt(buffer);
            try
            {
                array.inserirFim(lista.getPos(pos));
            }
            catch (Exception e)
            {
                 System.out.println(e.getMessage());
            }
            buffer = scan.nextLine();
        }while(!buffer.equals("FIM"));

        Q01(array, lista, scan);

        scan.close();
    }

    /**
     * Metodo para fazer as operacoes
     */
    public static void Q01 (LinkedList array, LinkedList lista, Scanner scan)
    {
        Pokemon tmp;

        int n = scan.nextInt();

        for(int i = 0; i <= n; i++)
        {
            String action = scan.nextLine();
            String[] args = action.split(" ");

            if(args[0].equals(("I")))
            {
                try 
                {
                    tmp = lista.getPos(Integer.parseInt(args[1]));
                    array.inserirFim(tmp);
                    // array.printList();
                    // scan.next();
                }
                catch (Exception e)
                {
                    System.err.println("Error");
                }
            }
            else if(args[0].equals(("R")))
            {
                try 
                {
                    array.removerFim();
                    // array.printList();
                    // scan.next();
                }
                catch (Exception e)
                {
                    System.err.println("Error");
                }
            }
        }

        array.printList();
    }
}

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

    public static void readAllFile(final String fileToRead, LinkedList list)
    {   
        try (BufferedReader br = new BufferedReader(new FileReader(fileToRead)))
        {
            br.readLine();
        
            String csvLine;
            while((csvLine = br.readLine()) != null)
            {
                csvLine = lineFormat(csvLine);

                Pokemon pokemon = new Pokemon(csvLine.split(";"));
                
                list.inserirFim(pokemon);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
}

class Node extends Pokemon
{
    Pokemon data;
    Node next;

    public Node ()
    {
        this.data = new Pokemon();
        this.next = null;
    }    

    public Node (Pokemon pokemon)
    {
        this.data = pokemon;
        this.next = null;
    }
}

class LinkedList
{
    private Node first;
    private Node last;

    public LinkedList()
    {
        //acho que o problema é no parametro
        this.first = new Node(); 
        this.last = first;
    }


    public void inserirInicio(Pokemon pokemon)
    {
        Node tmp = new Node(pokemon);

        tmp.next = first.next;
        first.next = tmp;

        if(first == last)
        {
            last = tmp;
        }

        tmp = null;
    }

    public void inserirFim (Pokemon pokemon)
    {
        last.next = new Node(pokemon);
        last = last.next;
    }

    public void inserir (Pokemon pokemon, int pos) throws Exception
    {
        int tamanho = tamanho();

        if(pos < 0 || pos > tamanho)
        {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        }
        else if(pos == 0)
        {
            inserirInicio(pokemon);
        }
        else if(pos == tamanho)
        {
            inserirFim(pokemon);
        }
        else
        {
            Node i = first;
            for(int j = 0; j < pos; j++, i = i.next);

            Node tmp = new Node(pokemon);

            tmp.next = i.next;
            i.next = tmp;
            tmp = i = null;
        }
    }

    public Pokemon removerInicio () throws Exception
    {
        if(first == last)
        {
            throw new Exception("Erro ao remover (vazia)!");
        }
        Node tmp = first;
        first = first.next;

        Pokemon resp = first.data;

        tmp.next = null;
        tmp = null;

        System.out.println("(R) " + resp.getName());
        return resp;
    }

    public Pokemon removerFim () throws Exception
    {
        if(first == last)
        {
            throw new Exception("Erro ao remover (vazia)!");
        }

        Node i;

        for(i = first; i.next != last; i = i.next);

        Pokemon resp = last.data;

        last = i;

        i = last.next = null;

        System.out.println("(R) " + resp.getName());
        return resp;
    }

    public Pokemon remover (int pos) throws Exception
    {
        Pokemon resp;
        int tamanho = tamanho();

        if(first == last)
        {
            throw new Exception("Erro ao remover (vazia)!");
        }
        else if(pos < 0 || pos >= tamanho)
        {
            throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        }
        else if(pos == 0)
        {
            resp = removerInicio();
        }
        else if(pos == (tamanho - 1))
        {
            resp = removerFim();
        }
        else
        {
            Node i = first;
            for(int j = 0; j < pos; j++, i = i.next);

            Node tmp = i.next;
            resp = tmp.data;
            i.next = tmp.next;
            tmp.next = null;
            i = tmp = null;
        }
        System.out.println("(R) " + resp.getName());
        return resp;
    }

    public Pokemon getPos(int pos) throws Exception
    {
        Pokemon resp;
        int tamanho = tamanho();

        if(first == last)
        {
            throw new Exception("Erro ao remover (vazia)!");
        }
        else if(pos < 0 || pos >= tamanho)
        {
            throw new Exception("Erro ao obter (posição " + pos + " inválida para tamanho " + tamanho + ")");
        }
        else
        {
            Node i = first;
            for(int j = 0; j < pos; j++, i = i.next);

            resp = i.data;
        }
        return resp;
    }

    public void printList ()
    {
        int j;
        Node i;
        for(j = 0, i = first.next; i != null; i = i.next, j++)
        {
            System.out.println("[" + j + "] " + i.data);
        }
    }
    
    public int tamanho ()
    {
        int tamanho = 0;

        for(Node i = first; i != last; i = i.next, tamanho++);

        return tamanho;
    }
}

