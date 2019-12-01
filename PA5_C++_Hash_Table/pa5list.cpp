/// Name:Ajit Pandey
// USC NetID:ajitpand
// CS 455 PA5
// Fall 2019

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {
	char command;
	bool done = true;
	string key;
	int  value;
	Node *theList = NULL;

	
	while(done){
    cout << "\nPlease enter a command [i, c,r, s, g, p, a, u, q]: ";
	cin >> command;

	            switch (command) {
	                case 'i':
	                    cout << "Insert Key and Value in front. String key: ";
	                    cin >> key;
	                    cout <<"Value for the Key: ";
	                    cin>> value;
	                    insertFront (theList, key, value);
	                    break;
	                case 'c':
	                    cout << "Find of key contains in list: ";
	                    cin >> key;
	                    cout << contains (theList, key)<< endl;
	                    break;
	                case 'r':
	                    cout << "Remove key in the list.";
	                    cin >> key;
	                    listRemove(theList, key);
	                    break;
	                case 's':
	                    cout << "size of the list";
	                    value = numberOfList(theList);
 	                    cout << "Size of the list is : " << value <<endl;
	                    break;
	                case 'g':
	                	cout << "Value for the key";
	                	int * val;
	                    val = get(theList, key);
	                    if(val ==  NULL){
	                    	cout << "key doesn't exist!";
	                    }else {
	                    	cout << "value is: " << (*val) << endl;
	                    }
	                    break;
	                case 'p':
	                    cout << "The list is:  " << endl;
	                    listPrint(theList);
	                    cout << endl;
	                    break;
	                case 'a':
	                	cout << "Append the list at the end " << endl;
                        cout << "Append a key in the list.  Key is: " << endl;
                        cin >> key;
                        cout <<"New Value is:";
                        cin>> value;
                        listAppend(theList, key, value);
	                	break;
	                case 'u':
	                	cout << "update the value of a key in the list.  Key is: " << endl;
	                	cin >> key;
	                    cout <<"New Value is:";
	                    cin>> value;
	                    updateValue(theList, key, value);
	                	break;
	                case 'q':
	                    done = false;
	                    break;
	                 }
	            

	        }
   cout << "The updated list: " << endl;
   listPrint(theList);
   return 0;
}
