# Binary Steganography
A tool for hiding and unhiding binary files.

## Hide a file
You provide the file that you want to hide a file in, the file you want to hide, and the name of the new file it will create.
```
java -jar BinarySteganography.jar original_file hidden_file new_file
```

## Unhide a file
You provide the name of the file that contains your hidden file, and the name of the new file that it will create. Make sure it matches the same file extension as the hidden file.
```
java -jar BinarySteganography.jar file new_file

```