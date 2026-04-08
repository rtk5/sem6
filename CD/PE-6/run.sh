#!/bin/bash

echo "Cleaning..."
rm -f parser.tab.* lex.yy.c ic_generator output.txt

echo "Bison..."
bison -d parser.y

echo "Flex..."
flex lexer.l

echo "Compiling..."
gcc parser.tab.c lex.yy.c -o ic_generator

echo "Running..."
./ic_generator

echo "Done! Check output.txt"
