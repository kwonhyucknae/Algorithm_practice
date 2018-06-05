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

int check(vector<int> vc,int i)
{
	int left,right,ck;
	left = max(vc[i - 1], vc[i - 2]);
	right = max(vc[i + 1], vc[i + 2]);
	ck = max(left, right);

	if (vc[i] > ck)
		return vc[i] - ck;

	return 0;
}


int main()
{
	
	for (int i = 0; i < 10; i++)
	{
		vector<int> vc;

		int length = 0,ans=0;
		cin >> length;

		for (int j = 0; j < length; j++)
		{
			int temp;
			cin >> temp;
			vc.push_back(temp);
		}

		for (int k = 2; k < vc.size() - 2; k++)
		{
			ans += check(vc, k);
		}
		cout << "#"<<i+1<<" "<<ans << endl;
	}

}