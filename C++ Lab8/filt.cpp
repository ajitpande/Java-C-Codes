/*Name: Ajit PAndey
 *USCID: ajitpand 
 *Lab 11
 *CS455 Fall 2019
*/

#include <iostream>
#include<vector>

using namespace std;

vector<int> readVals(){
	vector<int> v;
	int number;
	cout<< "Enter the numbers: ";
	while (cin >> number){
		v.push_back(number);
	}
	return v;
}

void printVal(vector<int> vPrint){

	for (int i =0; i < vPrint.size(); i++){
		cout << vPrint[i] << " ";
	}
	cout << endl;
}

vector<int> filter (vector<int> vFilter){
	vector<int> filter;

	for (int i =0 ; i < vFilter.size(); i++){
		if (vFilter[i] > 10){
			int temp = vFilter[i];
			filter.push_back(temp);
		}
	}
	return filter;
}


int main() {
	vector<int> vTest;
	vector<int> filterTest;
	vTest = readVals();

	filterTest = filter(vTest);
	cout << "Filtered Vector [greater than 10]: ";
	printVal(filterTest);
	cout << "Original Vector: ";
	printVal(vTest);
	cout << endl;
	return 0;
}



