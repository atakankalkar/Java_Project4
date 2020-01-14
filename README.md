# Java_Project4
This project is about creating spotify-like environment with hash table data structure.This program also works on command line with menu method.

This project consists of 3 different hash table.
First hash table stores person names.For collusions on this table , linear probing method used.
Second hash table stores songs that people like in same index with first hash table. using chaining method.
Third hash table stores people that likes same song. For same songs , chaining method have used.

Hash Function
Hash function converts given string's characters to ascii values.Then, these values are added together and sum value, divided to size of hash table which is 100 and remainder value becomes index value for given key.


I method = Registering new person to first  hash table.
L method = New song registering to second hash table with applying hash function to given name , with applying hash function to given song name,  registering to third hash table given person name with obtained index. 
E method = Erases song assignment.
D method = Deletes person register.
P method = Prints given person's liked songs.
M method = Checks other person's liked songs and prints similarity rates.
R method = Recommend new songs to given name using match algorithm, different songs that matched people liked are proposed to given person.
O method = Provides input from given txt file.

