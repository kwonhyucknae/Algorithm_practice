#include <iostream>
#include <stdio.h>
#include <string.h>
#include <string>
#include <algorithm>
#include <stack>
#include <queue>
#include <deque>
#include <math.h>
#include <stdio.h>
using namespace std;
/*
int card[500001];
int seach[500001];
int ans[20000002];

bool twosearch(int left, int right, int searchnum,int size)
{
	int mid = (left + right) / 2;
	bool result;
	if (left > right)
		return false;
	else {
		if (card[mid] > searchnum)
		{
			result = twosearch(left, mid - 1, searchnum,size);
		}
		else if (card[mid] < searchnum)
		{
			result = twosearch(mid + 1, right, searchnum,size);
		}
		else
		{
			//card는 정렬이 된 상태 
			while (card[mid]==searchnum)
			{
				mid--;
				if (searchnum == 0)
				{
					if (mid < 0)
						break;
				}
			}
			mid++;

			if (searchnum < 0)
			{
				if (ans[abs(searchnum) + 10000000] == 0)
				{
					while (mid <= size && searchnum == card[mid])
					{

							ans[abs(searchnum) + 10000000]++;

						mid++;
					}
				}
			}
			else
			{
				if (ans[searchnum] == 0)
				{
					while (mid <= size && searchnum == card[mid])
					{

						ans[searchnum]++;
						
						mid++;
					}
				}

			}
			

			return true;
		}
		return result;

	}
}


int main()
{	
	//memset(ans, 10000001, sizeof(ans));

	int n,m;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> card[i];
		
	}
	cin >> m;
	for (int j = 0; j < m; j++)
	{
		cin >> seach[j];
	}

	sort(card,card+n);

	for (int i = 0; i < m; i++)
	{
		int searchnum = seach[i];
		int left = 0;
		int right = n-1;
		int temp = 0;
		
		if (searchnum < 0)
		{
			temp = abs(searchnum) + 10000000;
			if (ans[temp] != 0)
			{
				printf("%d ", ans[temp]);
			}
			else
			{
				if (twosearch(left, right, searchnum, n))
				{
					if (searchnum < 0)
					{
						temp = abs(searchnum) + 10000000;
						searchnum = temp;
					}
					printf("%d ", ans[searchnum]);
				}
				else
				{

					printf("0 ");
				}
			}
		}
		else
		{
			if (ans[searchnum] == 0)
			{
				if (twosearch(left, right, searchnum, n))
				{
					printf("%d ", ans[searchnum]);
				}
				else
				{

					printf("0 ");
				}
			}
			else
			{
				printf("%d ", ans[searchnum]);

			}
		}

	}
	printf("\n");
}
*/


long long a[1000001];
long long b[1000001];

int main()
{
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		cin >> a[i];
	}
	for (int i = 0; i < m; i++)
	{
		cin >> b[i];
	}
	int c=0, d=0;
	while (true)
	{
		if (c == n || d == m) break;
		if (a[c] > b[d])
		{
			printf("%lld ", b[d]);
			d++;
		}
		else if(a[c]<b[d])
		{
			printf("%lld ", a[c]);
			c++;
		}
		else if (a[c] == b[d])
		{
			printf("%lld %lld ", b[d], a[c]);
			d++;
			c++;

		}
	}
	while (c!=n)
	{
		printf("%lld ", a[c]);
		c++;
	}
	while (d != m)
	{
		printf("%lld ", b[d]);
		d++;
	}
	printf("\n");
}
