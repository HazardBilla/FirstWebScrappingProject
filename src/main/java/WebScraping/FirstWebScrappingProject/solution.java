package WebScraping.FirstWebScrappingProject;


class A
{
	 public int a;
	 public void display()
	 {
		 System.out.println("in A");
	 }
}

class B extends A 
{
	int b;
//	public void display(int a )
//	{
//		System.out.println("in B");
//	}
	public void display()
	 {
		 System.out.println("in BA");
	 }
}
public class solution {
public static void main(String[] args)
{
	int arr[][]=new int[3][3];
	int a1[]= {1,2,3};
	arr[0]=a1;
	System.out.println(arr[0][2]);
}
}
