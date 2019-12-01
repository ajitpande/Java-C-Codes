// Name:Ajit Pandey
// USC NetID:ajitpand
// CSCI 455 PA5
// Fall 2019

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>
void printCommand();
using namespace std;

int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*

   	   string command = "";
       bool done = true;
       string name = "";
       int score = 0;

       while(done){
           cout << "Enter command: " << endl;
           cin >> command;

           if(command == "insert"){
        	   cout << "Enter name: " << endl;
               cin >> name;
               cout << "Enter score: " << endl;
               cin >> score;
               grades->insert(name, score);

           }else if(command == "change"){

        	   cout << "Enter name: " << endl;
        	   cin >> name;
        	   cout << "Enter score: " << endl;
        	   cin >> score;

               if(grades->lookup(name) == NULL){
                   cout << "Name doesn't exist." << endl;
               }else{
                   *(grades->lookup(name)) = score;
               }
           }else if(command == "lookup"){
        	   cout << "Enter name: " << endl;
        	   cin >> name;
               if(grades->lookup(name) == NULL){
                   cout << "Name doesn't exist." << endl;
               }else{
                   cout << name << ": "<< *(grades->lookup(name)) << endl;
               }

           }else if(command == "remove"){
        	   cout << "Enter name: " << endl;
               cin >> name;
               grades->remove(name);

           }else if(command == "print"){
               grades->printAll();

           }else if(command == "size"){
               cout <<" Size is: " << grades->numEntries() << endl;

           }else if(command == "Hash Stats"){
               grades->hashStats(cout);

           }else if(command == "help"){

               printCommand();

           }else if(command == "quit"){  //Exit
               done = false;
           }else{
               cout << "ERROR: invalid command, please type help to see the command summary" << endl;
           }
       }


     return 0;
   }


   void printCommand(){

       cout << "The valid command are as follows: " << endl;
       cout << "insert name score: Insert this name and score in the grade table." << endl;
       cout << "change name newscore: Change the score for name." << endl;
       cout << "lookup name: Lookup the name, and print out his or her score, or a message indicating that student is not in the table." << endl;
       cout << "remove name: Remove this student." << endl;
       cout << "print: Prints out all names and scores in the table." << endl;
       cout << "size: Prints out the number of entries in the table." << endl;
       cout << "stats: Prints out statistics about the hash table at this point. (Calls hashStats() method)" << endl;
       cout << "help: Prints out a brief command summary." << endl;
       cout << "quit: Exits the program." << endl;

   }
