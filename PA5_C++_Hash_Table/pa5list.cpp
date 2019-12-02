// Name:Ajit Pandey
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
		   string command = "";
	       bool done = true;
	       string name = "";
	       int value = -1;

	       while(done){
	           cout << "Enter command: " << endl;
	           cin >> command;

	           if(command == "insert"){
	        	   cout << "Enter name: " << endl;
	               cin >> name;
	               cout << "Enter value: " << endl;
	               cin >> value;
	               insertFront (list, key, value);

	           }else if(command == "change"){

	        	   cout << "Enter name: " << endl;
	        	   cin >> name;
	        	   cout << "Enter new value: " << endl;
	        	   cin >> value;
	        	   updateValue(list, key, value);
	        	   
	           }else if(command == "get"){
	        	   cout << "Enter name: " << endl;
	        	   cin >> name;
	        	   int * val;
	        	   val = get(list, key);
	        	   if(val ==  NULL){
	        	      cout << "key doesn't exist!";
	        	   }else {
	        	   cout << "value is: " << (*val) << endl;
	        	   }
	           }else if(command == "remove"){
	        	   cout << "Enter name: " << endl;
	               cin >> name;
	               listRemove(list, key);

	           }else if(command == "print"){
	        	   cout << "The list is:  " << endl;
	        	   listPrint(list);
	        	   cout << endl;

	           }else if(command == "size"){
	        	   cout << "size of the list";
	        	   value = numberOfList(list);
	        	   cout << "Size of the list is : " << value <<endl;

	           }else if(command == "quit"){  //Exit
	               done = false;
	           }else{
	               cout << "Incorrect command" << endl;
	           }
	       }

	       cout << "The updated list: " << endl;
	          listPrint(list);
	     return 0;
}
