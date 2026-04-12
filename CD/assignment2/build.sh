#!/bin/bash

echo "Cleaning..."
rm -f parser.tab.* lex.yy.c ic_generator ast_output.txt ic_output.txt

echo "Running Bison..."
bison -d parser.y
if [ $? -ne 0 ]; then echo "Bison failed!"; exit 1; fi

echo "Running Flex..."
flex lexer.l
if [ $? -ne 0 ]; then echo "Flex failed!"; exit 1; fi

echo "Compiling..."
gcc parser.tab.c lex.yy.c -o ic_generator
if [ $? -ne 0 ]; then echo "GCC failed!"; exit 1; fi

echo "Running with test input..."
./ic_generator < test_input.c

echo ""
echo "=== AST Output ==="
cat ast_output.txt

echo ""
echo "=== Intermediate Code ==="
cat ic_output.txt
