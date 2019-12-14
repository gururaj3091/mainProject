package javaPractice;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		System.out.println("Enter the no to be reversed: ");
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		int x=n,rem,sum=0;
		while(n>0)
		{
			rem = n%10;
			sum = sum*10+rem;
			n=n/10;
		}
		System.out.println("reverse of a no is : "+sum);
		
		if(x==sum)
		{
			System.out.println("entered no "+x+" is a palindrome");
		}
		else
		{
			System.out.println("Not");
		}
		
	}

}
