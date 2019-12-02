// Name: Ajit Pandey
// USC NetID:ajitpand
// CSCI 455 PA5
// Fall 2019


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

/**Insert the key and value in front of the list, No change to table if the key already exists.
 *@param list: the list to insert the entry
 *@param key: the key of table 
 *@param value: the value of the entry
 *@return true if the InsertFront operation is completed.
 */
bool insertFront(ListType & list, const std::string & key, int value){

	if(contains(list, key)){
	      cout << "key already exists, cannot insert."<< endl;
	        return false;
	    }

	Node *newguy = new Node(key, value);
	newguy->next = list;
	list = newguy;
	return true;
}


/**Check if the key is present in the list
 *@param list: the list to be checked
 *@param key: the key of the entry
 *@return true if the key exist
 */
bool contains(ListType & list, const std::string & key){
	Node *newguy = list;
	while(newguy != NULL){
	   if(newguy ->key == key){
	            return true;
	     }
	   newguy = newguy ->next;
	 }
    return false;
}


/**Remove a key and its respective value in the list
 *@param list: the list to remove the entry
 *@param key: the key of the entry
 *@return true if the Remove operation is completed.
 */
bool listRemove(ListType & list, const std::string & key){
	if (list == NULL) {
		return false;
	}
	Node * node = list;
	Node * pre = NULL;
	if(node -> key == key){
	     Node * temp = list;
	     list = temp -> next;
	     delete temp;
	     return true;
    }
	while(node != NULL){
	    if(node -> key == key){
	        pre -> next = node -> next;
	        delete node;
	        return true;
	    }
	        pre = node;
	        node = node -> next;
	    }

	    return false;
}


/**Return the number of entries in the list
 *@param list: the list to be counted for number of entries
 *@return the int number of entries in the list
 */
int numberOfList(ListType & list){
	Node * node = list;
	int num = 0;
	while(node != NULL){
	   num++;
	   node = node -> next;
	 }
	 return num;
}


/**Search a key and associated value in the list
 *@param list: the list to be searched for give key and its respective value
 *@param key: the key of the entry
 *@return the int value.
 *@return NULL if key is not present in the list. 
 */
int * get(ListType & list, const std::string & key){
	Node * node = list;;
	while (node != NULL) {
	      if (node->key == key) { return &(node->value); }
	      node = node->next;
	   }
	   return NULL;

}

/**Print all entries in the list
 *@param list: the list to be printed for key and respevtive values
 */
void listPrint(ListType & list){
	Node * node = list;
	while(node != NULL){
	   cout << node -> key << " " << node -> value << endl;
	   node = node -> next;
	}
}


/**Append a at the end of the list with given key-value entry
 *@param list: the list to be appended 
 *@param key: the key of the entry
 *@param value: the value of the entry
 *@return true if the append is successful
 */
bool listAppend(ListType & list, const std::string & key, int value){

	if(contains(list, key)){
	   cout <<"Key already exists, cannot append.";
	   return false;
	 }
	 Node * node = list;
	 Node * newNode = new Node(key, value);
	 if(node == NULL){
	    list = newNode;
	    return true;
	 }
	 while(node -> next != NULL){
	     node = node -> next;
	 }
	 node -> next = newNode;
	 return true;
}

/**Update a value for a key which is present in the list
 *@param list: the list to be updated for a value for giben key
 *@param key: the key of the entry
 *@param value: the value of the entry
 *@return true if the update operation is completed
 */
bool updateValue(ListType & list, const std::string & key, int value){
	int * oldValue = get(list, key);
	if(oldValue != NULL){
	    *oldValue = value;
	    return true;
	} else {
	    cout << "Key doesn't exist, cannot update!" << endl;
	    return false;
	}
}

