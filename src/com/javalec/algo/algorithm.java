package com.javalec.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class algorithm {
	
	static long[] heap;
	static long[] minheap;
	static int size=0;
	static int minsize=0;
	
	static void add(long x)
	{
		int idx=size;
		heap[size++]=x;
		while(true)
		{
			int p=(idx-1)/2;
			if(heap[p]<heap[idx])
			{
				long tmp=heap[p];
				heap[p]=heap[idx];
				heap[idx]=tmp;
				idx=p;
			}
			else 
				break;
		}
	}
	static void minadd(long x)
	{
		int idx=minsize;
		minheap[minsize++]=x;
		while(true)
		{
			int p=(idx-1)/2;
			if(minheap[p]>minheap[idx])
			{
				long tmp=minheap[p];
				minheap[p]=minheap[idx];
				minheap[idx]=tmp;
				idx=p;
				
			}
			else
				break;
		}
	}
	
	static long remove()
	{
			long ret=heap[0];
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
					long temp=heap[idx];
					heap[idx]=heap[MAX];
					heap[MAX]=temp;
					idx=MAX;
				}
			}
			
			return ret;
	}
	static long minremove()
	{
			long ret=0;
			ret=minheap[0];
			minheap[0]=minheap[size-1];
			minsize--;
			int idx=0;
			
			while(true)
			{
				int MIN=idx;
				if(idx+(idx+1)<minsize && minheap[idx+(idx+1)]<minheap[MIN])
				{
					MIN=idx+(idx+1);
				}
				if(idx+(idx+2)<minsize && minheap[idx+(idx+2)]<minheap[MIN])
				{
					MIN=idx+(idx+2);
					
				}
				if(MIN==idx)
					break;
				else
				{
					long temp=minheap[idx];
					minheap[idx]=minheap[MIN];
					minheap[MIN]=temp;
					idx=MIN;
				}
			}
			return ret;
	}
	
public static void main(String[] args) throws IOException {
	
	InputStreamReader isr= new InputStreamReader(System.in);
	BufferedReader br= new BufferedReader(isr);
	String line;
	
	line = br.readLine();
	long mid=0;
	
	for(int i=0;i<Integer.parseInt(line);i++)
	{
		String cnt;
		cnt=br.readLine();
		heap=new long[Integer.parseInt(cnt)];
		minheap=new long[Integer.parseInt(cnt)];
		minsize=0;
		size=0;
		StringBuffer sb=new StringBuffer();
		
		long[] nums=new long[Integer.parseInt(cnt)+1];
		int count=1;		
		int midcount=0;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int j=1;j<=Integer.parseInt(cnt);j++)
		{
			nums[j]=Long.parseLong(st.nextToken());
			if(j%10==0)st=new StringTokenizer(br.readLine()," ");
			
			if(j%2!=0)
			{
				if(j==1)
				{
					mid=nums[j];	
				}
				else
				{
					if(minheap[0]<nums[j])
					{
						mid=minremove();
						minadd(nums[j]);
					}
					else if(minheap[0]>nums[j] && heap[0]<nums[j])
					{
						mid=nums[j];
					}
					else if(heap[0]>nums[j])
					{
						mid=remove();
						add(nums[j]);
					}
				}
					//System.out.print(mid+" ");
					sb.append(mid+" ");
					midcount++;
					if(midcount%10 ==0)sb.append("\n");
			}
			else
			{
				if(mid>nums[j])
				{
					minadd(mid);
					add(nums[j]);
				}
				else
				{
					add(mid);
					minadd(nums[j]);
				}
			}
			//if(midcount %10 !=0) sb.append(" ");
			//count++;
			//if(midcount %10 ==0) sb.append("\n");
			
		}
		System.out.println(midcount);
		System.out.println(sb.toString());
		
	}
		
}

	
	
}
