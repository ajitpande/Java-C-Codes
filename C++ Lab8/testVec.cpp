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

void printVal(vector<int> v){

	for (int i =0; i < v.size(); i++){
		cout << v[i] << " ";
	}
	cout << endl;
}

int main() {
	vector<int> v;
	v = readVals();
    cout << "Vector: ";
	printVal(v);
	return 0;
}


