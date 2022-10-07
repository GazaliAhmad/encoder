# Caesar Cipher Encoder/Decoder!

What is a Caesar Cipher? 

It's a simple substitution cipher where each letter is replaced by another letter a certain number of letters away.
For example, if you shift the alphabet by 3, A becomes D, B becomes E, and so on.
This is a very simple cipher, but it's also very easy to break. It's also known as a shift cipher.

## Implementation

Get input from user. First character is the key to shift the alphabet by.
Second character is the string to be encoded.

## Example:

- If key is B and the string is ABC, the output will be `/AB`. The text is entered as `BABC`, the first character is the key, and the rest is the string to be encoded.
- If key is F and the string is ABC, the output will be `+,-`. The entered text is `FABC`. 
- If key is F and the string is Hello, the output will be `C/GGJ`. The entered text is `FHello`.

## Steps

- The array is looped through and the index of the character is found.
- The index is then shifted by the key and the character at that index is added to the output string.
- Two methods encode and decode are used to encode or decode the string.
- Regex is used to check if the input is valid.
