// Name: Ajit Pandey
// USC NetID:ajitpand
// CSCI 455 PA5
// Fall 2019


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  

struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

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
bool insertFront(ListType & list, const std::string & key, int value);


/**Check if the key is present in the list
 *@param list: the list to be checked
 *@param key: the key of the entry
 *@return true if the key exist
 */
bool contains(ListType & list, const std::string & key);


/**Remove a key and its respective value in the list
 *@param list: the list to remove the entry
 *@param key: the key of the entry
 *@return true if the Remove operation is completed.
 */
bool listRemove(ListType & list, const std::string & key);


/**Return the number of entries in the list
 *@param list: the list to be counted for number of entries
 *@return the int number of entries in the list
 */
int numberOfList(ListType & list);


/**Search a key and associated value in the list
 *@param list: the list to be searched for give key and its respective value
 *@param key: the key of the entry
 *@return the int value.
 *@return NULL if key is not present in the list. 
 */
int * get(ListType & list, const std::string & key);


/**Print all entries in the list
 *@param list: the list to be printed for key and respevtive values
 */
void listPrint(ListType & list);


/**Append a at the end of the list with given key-value entry
 *@param list: the list to be appended 
 *@param key: the key of the entry
 *@param value: the value of the entry
 *@return true if the append is successful
 */
bool listAppend(ListType & list, const std::string & key, int value);


/**Update a value for a key which is present in the list
 *@param list: the list to be updated for a value for giben key
 *@param key: the key of the entry
 *@param value: the value of the entry
 *@return true if the update operation is completed
 */
bool updateValue(ListType & list, const std::string & key, int value);

// keep the following line at the end of the file
#endif
