class Node
{
    int data;
    Node next;

    public Node ()
    {
        next = null;
        this.data = 0;
    }
    public Node (int data)
    {
        next = null;
        this.data = data;
    }
}
class mylist 
{
    Node head;

    public void add (int data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
        }
        else
        {
            Node current = head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void popback ()
    {
        Node current = head;
        while(current.next.next != null)
        {
            current = current.next;
        }

        current.next = null;
    }

    public void print ()
    {
        Node current = head;
        if(current.next == null)
        {
            System.out.println("?"+current.data);
        }
        else
        {
            while(current != null)
            {
                System.out.print(""+current.data);
                current = current.next;
            }
        }
        System.out.println("");
    }


    public static void main(String[] args)
    {
        mylist array = new mylist();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.print(); 
        array.popback();
        array.print();   
    }
}