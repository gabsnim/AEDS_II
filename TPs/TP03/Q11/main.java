import java.util.*;

public class main 
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		Matrix a = null, b = null, c = null;
		int n = 0, y = 0, x = 0;
		n = sc.nextInt();

		for (int i = 0; i < n; i++)
		{
			y = sc.nextInt();
			x = sc.nextInt();
			a = new Matrix(y);
			a.write(sc);

			y = sc.nextInt();
			x = sc.nextInt();

			b = new Matrix(y);
			b.write(sc);
		
			a.MainDiagonal();
			a.SecondaryDiagonal();

		    c = a.sum(b);
			c.print();

			c = a.mult(b);
			c.print();
		}
	}
}

class Node
{
	public int data;
	public Node up;
	public Node down;
	public Node left;
	public Node right;

	public Node (int x)
	{
		this.data = x;
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;
	}

	public Node ()
	{
		this(0);
	}

}

class Matrix
{
	public Node top;
	public int n;

	public Matrix (int n)
	{
		if (n > 1)
		{
			this.top = newRow(n);

			Node start = this.top;

			for (int i = 0; i < n; i++)
			{
				Node New = newRow(n);
				Node tmp = New;

				for (Node y = start; y != null; y = y.right)
				{
					y.down = tmp;
					tmp.up = y;
					tmp = tmp.right;
				}

				start = start.down;
			}
			this.n = n;
		}
		else
		{
			System.out.println ("Tamanho invalido");
		}
	}

	public Node newRow(int n)
	{
		Node res = null;
		if (n > 1)
		{
			res = new Node();
			Node ptr = res;

			for (int i = 0; i < n-1; i++)
			{
				Node tmp = new Node();
				ptr.right = tmp;
				tmp.left = ptr;
				ptr = tmp;
			}
		}
		return (res);
	}

	public void insert (int x, int c, int r)
	{
		if (r > -1 && r < this.n && c > -1 && c < this.n)
		{
			Node ptr = this.top;

			for (int i = 0; i < r; i++)
			{
				ptr = ptr.right;
			}

			for (int i = 0; i < c; i++)
			{
				ptr = ptr.down;
			}

			ptr.data = x;
		}
		else
		{
			System.out.println ("Posicao invalida");
			System.out.println ("n="+this.n);
			System.out.println ("r="+r+"\nc="+c);
		}
	}
	
	public void print ()
	{
		if (this.top != null)
		{
			Node row = this.top;
			Node ptr = row;
			
			for (int i = 0; i < this.n; i++)
			{
				for (int y = 0; y < this.n; y++)
				{
					System.out.print (ptr.data+" ");
					ptr = ptr.right;
				}
				System.out.println ("");

				row = row.down;
				ptr = row;
			}
		}
	}

	private void pMD (Node ptr)
	{
		System.out.print (ptr.data+" ");

		if (ptr.right != null && ptr.right.down != null)
		{
			pMD(ptr.right.down);
		}
	}

	public void MainDiagonal()
	{
		if (this.top != null)
		{
			pMD(this.top);
			System.out.println ("");
		}
	}

	private void pSD (Node ptr)
	{
		System.out.print (ptr.data+" ");
		if (ptr.left != null && ptr.left.down != null)
		{
			pSD(ptr.left.down);
		}
	}

	public void SecondaryDiagonal()
	{
		if (this.top != null)
		{
			Node tmp = this.top;
			while (tmp.right != null)
			{
				tmp = tmp.right;
			}
			pSD(tmp);
			System.out.println ("");
		}
	}

	public int get (int c, int r)
	{
		int res = 0;
		if (this.top != null && r > -1 && r < this.n && c > -1 && c < this.n)
		{
			Node ptr = this.top;

			for (int i = 0; i < r; i++)
			{
				ptr = ptr.right;
			}

			for (int i = 0; i < c; i++)
			{
				ptr = ptr.down;
			}

			res = ptr.data;
		}
		return (res);
	}

	public Matrix sum (Matrix other)
	{
		Matrix res = null;
		if (this.top != null && other.top != null)
		{
			if (this.n == other.n)
			{
				res = new Matrix(this.n);
				Node r1 = this.top;
				Node r2 = other.top;
				Node c1 = r1;
				Node c2 = r2;

				for (int i = 0; i < this.n; i++)
				{
					for (int y = 0; y < this.n; y++)
					{
						int x = c1.data + c2.data;
						res.insert(x, i, y);
						c1 = c1.right;
						c2 = c2.right;
					}
					r1 = r1.down;
					c1 = r1;
					r2 = r2.down;
					c2 = r2;
				}
				
			}
		}
		return (res);
	}


	public Matrix mult (Matrix other)
	{
		Matrix res = null;
		if (this.top != null && other.top != null)
		{
			if (this.n == other.n)
			{
				res = new Matrix(this.n);

				Node s2 = other.top;

				Node r1 = this.top;
				Node r2 = s2;
				Node r3 = res.top;

				Node c1 = r1;
				Node c2 = r2;
				Node c3 = r3;

				int tmp = 0;

				for (int x = 0; x < this.n; x++)
				{
					for (int y = 0; y < this.n; y++)
					{
						tmp = 0;
						for (int z = 0; z < this.n; z++)
						{
							tmp += c1.data * r2.data;
							c1 = c1.right;
							r2 = r2.down;
						}
						c3.data = tmp;
						c3 = c3.right;
						c1 = r1;
						c2 = c2.right;
						r2 = c2;
					}
					r1 = r1.down;
					c1 = r1;
					r2 = s2;
					c2 = r2;
					r3 = r3.down;
					c3 = r3;
				}

			}	
		}
		return (res);
	}

	public void write (Scanner sc)
	{
		for (int i = 0; i < this.n; i++)
		{
			for (int y = 0; y < this.n; y++)
			{
				int x = sc.nextInt();
				this.insert(x, i, y);
			}
		}
	}
}
