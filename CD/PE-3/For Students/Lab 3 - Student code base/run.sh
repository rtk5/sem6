#!/bin/bash

lex lexer.l
yacc -d parser.y
gcc y.tab.c lex.yy.c sym_tab.c -ll

./a.out < sample_input1.c > output1.txt