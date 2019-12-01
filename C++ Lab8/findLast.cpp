/*Name: Ajit PAndey
 *USCID: ajitpand 
 *Lab 11
 *CS455 Fall 2019
*/

#include <iostream>
#include<vector>
#include <fstream>
#include <string>

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


int findLast(vector<int> v, int target){

	int loc;
	for (int i =0; i < v.size(); i++){
		if (v[i] == target){
			loc = i;
		}
	}
	return loc;
}

int testFindLast (vector<int> temp, int target){
    
    return findLast(temp, target);
 }

int main() {
	vector<int> v;
    int target;
	v = readVals();
	cout << "Original Vector: ";
	printVal(v);
    cout << "Filtered Vector[greater than 10]: ";  
    printVal(filter(v));
    target =2;
    cout << "The last instance of " << target<< " is at position "<<findLast(v, target);
	
    cout << endl;
   
    ifstream infile1;
    ifstream infile2;
    infile1.open("in1");
    infile2.open("in2");
    if (infile1.fail() || infile2.fail() )
    {
    cout << "Could not open file numbers." << "\n";
    return 1;
    }
    int data1;
    vector<int> temp1;
    while (infile1 >> data1) {
    temp1.push_back(data1);
    }
    int data2;
    vector<int> temp2;
    while (infile2 >> data2) {
    temp2.push_back(data2);
    }
    printVal(temp1);
    printVal(temp2);
    cout << "testFindLast method starts: "<<"\n";
    cout << "the last instance of target "<< target<<" in file in1 is at "<<testFindLast(temp1, target)<< "\n";
    cout << "the last instance of taregt "<< target<<" in file in2 is at "<<testFindLast(temp2, target)<< "\n";
	return 0;
}


