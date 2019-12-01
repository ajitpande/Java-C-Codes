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
// create an empty table, i.e., one where numEntries() is 0
// (Underlying hash table is HASH_SIZE.)
Table::Table() {
	hashTable = new ListType[HASH_SIZE];
    hashSize = HASH_SIZE;
    for(int i = 0; i < hashSize; i++){
        hashTable[i] = NULL;
    }
}
// create an empty table, i.e., one where numEntries() is 0
// such that the underlying hash table is hSize
Table::Table(unsigned int hSize) {
	hashTable = new ListType[hSize];
	hashSize = hSize;
	for(int i = 0; i < hashSize; i++){
	     hashTable[i] = NULL;
	}
}

// returns the address of the value that goes with this key
// or NULL if key is not present.
//   Thus, this method can be used to either lookup the value or
//   update the value that goes with this key.
int * Table::lookup(const string &key) {
	   head = hashTable[hashCode(key)];
	   return get(head, key);
}
// remove a pair given its key
// false iff key wasn't present
bool Table::remove(const string &key) {
	   head = hashTable[hashCode(key)];
	   return listRemove(head, key);
}
	// insert a new pair into the table
   // return false iff this key was already present
   //         (and no change made to table)
bool Table::insert(const string &key, int value) {
    head = hashTable[hashCode(key)];
    return insertFront(head, key, value);
}

int Table::numEntries() const {
	int sum = 0;
	for(int i = 0 ; i < hashSize; i++){
	    sum += numberOfList(hashTable[i]);
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
        listPrint(hashTable[i]);
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
	int largestNum = 0;
	   int numNonEmpty = 0;
	   for (int i = 0; i < hashSize; i++) {
	      ListType head = hashTable[i];
	      if (numberOfList(head) > largestNum) { largestNum = numberOfList(head); }
	      if (head != NULL) { numNonEmpty++; }
	   }
	   out << "number of buckets: " << hashSize << endl;
	   out << "number of entries: " << numEntries() << endl;
	   out << "number of non-empty buckets: " << numNonEmpty << endl;
	   out << "longest chain: " << largestNum << endl;
}


// add definitions for your private methods here
