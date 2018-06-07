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


int card[500001];
int seach[500001];

bool twosearch(int left, int right, int searchnum)
{
	int mid = (left + right) / 2;
	bool result;
	if (left > right)
		return false;
	else {
		if (card[mid] > searchnum)
		{
			result = twosearch(left, mid - 1, searchnum);
		}
		else if (card[mid] < searchnum)
		{
			result = twosearch(mid + 1, right, searchnum);
		}
		else
		{
			return true;
		}
		return result;

	}
}


int main()
{	
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
		
		if (twosearch(left, right, searchnum))
		{
			printf("1 ");
		}
		else
		{
			printf("0 ");
		}

	}
	printf("\n");



}
