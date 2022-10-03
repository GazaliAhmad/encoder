# Encoder

A simple encoder/decoder based on shifting the letters in the alphabet.

Get input from user. First character is the key to shift the alphabet by.
Second character is the string to be encoded.

Example:

- If key is B and the string is ABC, the output will be /AB. 
- If key is F and the string is ABC, the output will be +,-. 
- If key is F and the string is Hello, the output will be C/GGJ
	
The array is looped through and the index of the character is found.
The index is then shifted by the key and the character at that index is added to the output string.
Two methods encode and decode are used to encode or decode the string.
