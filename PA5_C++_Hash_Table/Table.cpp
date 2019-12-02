// Name: Ajit Pandey
// USC NetID: ajitpand
// CSCI 455 PA5
// Fall 2019

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************
// Table class constructor. Initiates an empty table.
// HASH_SIZE from Table.h is used for table size. all entries are emplty -> NULL. ne where numEntries() is 0
// (Underlying hash table is HASH_SIZE.)
Table::Table() {
	table = new ListType[HASH_SIZE];
    hashSize = HASH_SIZE;
    for(int i = 0; i < hashSize; i++){
        table[i] = NULL;
    }
}
// Second Table class constructor. constructor passes HASH_SIZE has parameter. Initiates an empty table.
// HASH_SIZE from Table.h is used for table size. all entries are emplty -> NULL. ne where numEntries() is 0
// (Underlying hash table is HASH_SIZE.)
Table::Table(unsigned int hSize) {
	table = new ListType[hSize];
	hashSize = hSize;
	for(int i = 0; i < hashSize; i++){
	     table[i] = NULL;
	}
}

// returns the address of the value that goes with this key
// or NULL if key is not present.
//   Thus, this method can be used to either lookup the value or
//   update the value that goes with this key.
int * Table::lookup(const string &key) {
	   head = table[hashCode(key)];
	   return get(head, key);
}
// remove a pair given its key
// false iff key wasn't present
bool Table::remove(const string &key) {
	   head = table[hashCode(key)];
	   return listRemove(head, key);
}
	// insert a new pair into the table
   // return false iff this key was already present
   //         (and no change made to table)
bool Table::insert(const string &key, int value) {
    head = table[hashCode(key)];
    return insertFront(head, key, value);
}
// returns number of entries in the table.
int Table::numEntries() const {
	int sum = 0;
	for(int i = 0 ; i < hashSize; i++){
	    sum += numberOfList(table[i]);
	}
	return sum;
}

// print out all the entries in the table, one per line.
// Sample output:
//   zhou 283
//   sam 84
//   babs 99
void Table::printAll() const {
    for(int i = 0; i < hashSize; i++){
        listPrint(table[i]);
    }
}
// hashStats: for diagnostic purposes only
   // prints out info to let us know if we're getting a good distribution
   // of values in the hash table.
   // Sample output from this function
   //   number of buckets: 997
   //   number of entries: 10
   //   number of non-empty buckets: 9
   //   longest chain: 2
void Table::hashStats(ostream &out) const {
	int largestNumber = 0;
	   int numberNotEmpty = 0;
	   for (int i = 0; i < hashSize; i++) {
	      ListType head = table[i];
	      if (numberOfList(head) > largestNum) { largestNumber = numberOfList(head); }
	      if (head != NULL) { numberNotEmpty++; }
	   }
	   out << "number of buckets: " << hashSize << endl;
	   out << "number of entries: " << numEntries() << endl;
	   out << "number of non-empty buckets: " << numberNotEmpty << endl;
	   out << "longest chain: " << largestNumber << endl;
}


// add definitions for your private methods here
