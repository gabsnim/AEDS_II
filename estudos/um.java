class um
{
    public static void main(String[] args)
    {
        Lista array = new Lista();
        array.inserirFim(10);
        array.inserirFim(10);
        array.inserirInicio(8);
        array.print();
    }
}

class Node
{
    public int data;
    public Node next;

    public Node (int data)
    {
        this.data = data;
        next = null;
    } 
}

class Lista
{
    Node head = new Node(0);

    public void inserirFim (int x)
    {
        if(head == null)
        {
            System.out.println("erro");
        }
        Node tmp = new Node(x);
        Node i = head;
        for(i = head; i.next != null; i = i.next);

        i.next = tmp;
        // tmp.next = null;
    }

    public void removerFIm ()
    {
        if(head.next == null)
        {
            head = null;
            System.out.println("erro");
        }
        else
        {
            Node i;
            for(i = head; i.next.next != null; i = i.next);

            i.next = null;
        }
    }

    public void inserirInicio (int x)
    {
        if(head == null)
        {
            head = new Node (x);
        }
        {
            Node tmp = head;
            Node inicio = new Node (x);
            head = inicio;
            inicio.next = tmp;
            tmp = null;
        }
    }

    public void removerInicio ()
    {
        if(head.next == null)
        {
            head = null;
        }
        else
        {
            
        }
    }

    public void print()
    {
        Node i;
        for(i = head; i != null; i = i.next)
        {
            System.out.println(i.data);
        }
    }
}
