%{
#include "sym_tab.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void yyerror(char* s);
int yylex();

extern int yylineno;
extern int yycolumn;

int size;
int scope = 0;

char current_type[20];
char current_storage[20] = "auto";

char current_file[] = "input.c";
%}

/* 🔥 FIX */
%union {
    char* str;
}

%token <str> T_ID T_NUM
%token T_INT T_CHAR T_DOUBLE T_FLOAT
%token T_STATIC T_EXTERN T_REGISTER
%token T_MAIN

%start START

%%

START : PROG { printf("Valid syntax\n"); }
      ;

PROG : MAIN PROG
     | DECLR ';' PROG
     | ASSGN ';' PROG
     |
     ;

DECLR : TYPE LISTVAR ;

LISTVAR : LISTVAR ',' VAR
        | VAR
        ;

VAR: T_ID
{
    symbol* s = create_symbol(
        $1,"variable",current_type,current_storage,
        size,yylineno,yycolumn,current_file,scope);

    insert_symbol(s);
}
| T_ID '=' T_NUM
{
    symbol* s = create_symbol(
        $1,"variable",current_type,current_storage,
        size,yylineno,yycolumn,current_file,scope);

    insert_symbol(s);
    update_value($1,$3);
}
;

TYPE : T_INT    { strcpy(current_type,"int"); size=4; }
     | T_FLOAT  { strcpy(current_type,"float"); size=4; }
     | T_DOUBLE { strcpy(current_type,"double"); size=8; }
     | T_CHAR   { strcpy(current_type,"char"); size=1; }
     ;

ASSGN : T_ID '=' T_NUM
{
    update_value($1,$3);
}
;

MAIN : TYPE T_MAIN '(' ')' '{'
{
    symbol* s = create_symbol(
        "main","function",current_type,"auto",
        size,yylineno,yycolumn,current_file,scope);

    insert_symbol(s);
    scope++;
}
STMT
'}'
{
    scope--;
}
;

STMT : DECLR ';' STMT
     | ASSGN ';' STMT
     |
     ;

%%

void yyerror(char* s)
{
    printf("Error: %s at line %d\n", s, yylineno);
}

int main()
{
    t = allocate_space_for_table();
    yyparse();
    display_symbol_table();
    return 0;
}