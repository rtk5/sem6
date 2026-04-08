#!/bin/bash

echo "Cleaning old files..."
rm -f parser.tab.* lex.yy.c ast_parser output.txt

echo "Running Bison..."
bison -d parser.y

echo "Running Flex..."
flex lexer.l

echo "Compiling..."
gcc parser.tab.c lex.yy.c ast.c -o ast_parser

echo "Executing..."
./ast_parser

echo "Done! Check output.txt"
