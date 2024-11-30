class prova2
{
    public static void main(String[] args)
    {
        List a = new List();
        a.pushBack(1);
        a.pushBack(1);    
        a.pushBack(1);
        a.print();
    }
}

class Node
{
    public int data;
    public Node prox;

    Node(int data)
    {
        this.data = data;
        prox = null;
    }
}

class List
{
    Node head = null;

    public void pushBack(int data)
    {
        Node tmp = new Node(data);
        Node i;
        if(head == null)
        {
            head = tmp;
        }
        else
        {
            for(i = head; i.prox != null; i = i.prox);
            i.prox = tmp;
            tmp.prox = null;
        }
    }

    public void print ()
    {
        Node tmp = head;

        if(tmp == null)
        {
            System.out.println("erro");
        }
        else
        {
            Node i;
            for(i = tmp; i != null; i = i.prox)
            {
                System.out.println(i.data);
            }
        }
    }
}

