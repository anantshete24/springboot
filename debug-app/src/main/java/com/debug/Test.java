package com.debug;

public class Test {

	public static void main(String[] args) {
		System.out.println("Going to debug our Java Application");
		int myarr[]= {2,5,7,8};
		int sum=getSum(myarr);
		System.out.println("Sum="+sum);
	}

	public static int getSum(int ar[])
	{
		int s=0;
		for(int i=0; i<ar.length;i++)
		{
			s=s+ar[i];
		}
		//by mistake we added 3 so we will analyze it
		s=s+3;
		return s;
		
	}
}
