package com.javalec.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class algorithm {
	static int[] heap;
	static int size=0;
	
	
	static void add(int x)
	{
		int idx=size;
		heap[size++]=x;
		while(true)
		{
			int p=(idx-1)/2;
			if(heap[p]<heap[idx])
			{
				int tmp=heap[p];
				heap[p]=heap[idx];
				heap[idx]=tmp;
				idx=p;
			}
			else 
				break;
		}
		
		
	}
	static void remove()
	{
		if(size==0)
			System.out.println("0");
		else
		{
			System.out.println(heap[0]);
			heap[0]=heap[size-1];
			size--;
			int idx=0;
			
			while(true)
			{
				int MAX=idx;
				if(idx+(idx+1)<size && heap[idx+(idx+1)]>heap[MAX])
				{
					MAX=idx+(idx+1);
				}
				if(idx+(idx+2)<size && heap[idx+(idx+2)]>heap[MAX])
				{
					MAX=idx+(idx+2);
					
				}
				if(MAX==idx)
					break;
				else
				{
					int temp=heap[idx];
					heap[idx]=heap[MAX];
					heap[MAX]=temp;
					idx=MAX;
				}
			}
		}
		
		
	}
	
	
public static void main(String[] args) throws IOException {
	InputStreamReader isr= new InputStreamReader(System.in);
	BufferedReader br= new BufferedReader(isr);
	String line;
	
	line = br.readLine();
	heap=new int[Integer.parseInt(line)];
	
	for(int i=0;i<Integer.parseInt(line);i++)
	{
//		InputStreamReader isr2= new InputStreamReader(System.in);
//		BufferedReader br2=new BufferedReader(isr2);
//		
		String test2=br.readLine();
		if(Integer.parseInt(test2)==0)
		{
			remove();
		}
		else
		{
			add(Integer.parseInt(test2));
		}
		
		
		
	}
	
	
}
}
