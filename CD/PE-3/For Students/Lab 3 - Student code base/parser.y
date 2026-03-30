%{
    #include "sym_tab.h"
    #include <stdio.h>
    #include <stdlib.h>
    #include <string.h>

    #define YYSTYPE char*

    void yyerror(char* s);
    int yylex();
    extern int yylineno;

    // 🔥 tracking variables
    int current_type;
    int size;
    int scope = 0;
%}

%token T_INT T_CHAR T_DOUBLE T_WHILE T_INC T_DEC T_OROR T_ANDAND
%token T_EQCOMP T_NOTEQUAL T_GREATEREQ T_LESSEREQ T_LEFTSHIFT T_RIGHTSHIFT
%token T_PRINTLN T_STRING T_FLOAT T_BOOLEAN T_IF T_ELSE
%token T_STRLITERAL T_DO T_INCLUDE T_HEADER T_MAIN T_ID T_NUM

%start START

%%

START : PROG { printf("Valid syntax\n"); YYACCEPT; }
      ;

PROG : MAIN PROG
     | DECLR ';' PROG
     | ASSGN ';' PROG
     |
     ;

DECLR : TYPE LISTVAR
      ;

LISTVAR : LISTVAR ',' VAR
        | VAR
        ;

VAR: T_ID '=' EXPR
{
    if(check_symbol_table($1))
    {
        printf("Error: Redeclaration of %s at line %d\n", $1, yylineno);
    }
    else
    {
        symbol* s = allocate_space_for_table_entry($1, size, current_type, yylineno, scope);
        insert_into_table(s);
        insert_value_to_name($1, $3);
    }
}
| T_ID
{
    if(check_symbol_table($1))
    {
        printf("Error: Redeclaration of %s at line %d\n", $1, yylineno);
    }
    else
    {
        symbol* s = allocate_space_for_table_entry($1, size, current_type, yylineno, scope);
        insert_into_table(s);
    }
}
;

// assign type + size
TYPE : T_INT    { current_type = INT; size = 4; }
     | T_FLOAT  { current_type = FLOAT; size = 4; }
     | T_DOUBLE { current_type = DOUBLE; size = 8; }
     | T_CHAR   { current_type = CHAR; size = 1; }
     ;

/* Assignment */
ASSGN : T_ID '=' EXPR
{
    if(!check_symbol_table($1))
    {
        printf("Error: Undeclared variable %s at line %d\n", $1, yylineno);
    }
    else
    {
        insert_value_to_name($1, $3);
    }
}
;

EXPR : EXPR REL_OP E   { $$ = $1; }
     | E               { $$ = $1; }
     ;

E : E '+' T   { $$ = $1; }
  | E '-' T   { $$ = $1; }
  | T         { $$ = $1; }
  ;

T : T '*' F   { $$ = $1; }
  | T '/' F   { $$ = $1; }
  | F         { $$ = $1; }
  ;

F : '(' EXPR ')'  { $$ = $2; }
  | T_ID          { $$ = $1; }
  | T_NUM         { $$ = $1; }
  | T_STRLITERAL  { $$ = $1; }
  ;

REL_OP : T_LESSEREQ
       | T_GREATEREQ
       | '<'
       | '>'
       | T_EQCOMP
       | T_NOTEQUAL
       ;

/* MAIN FUNCTION */
MAIN : TYPE T_MAIN '(' EMPTY_LISTVAR ')' '{'
{
    scope++;   // enter main scope
}
STMT
'}'
{
    scope--;   // exit main scope
}
;

EMPTY_LISTVAR : LISTVAR
              |
              ;

STMT : STMT_NO_BLOCK STMT
     | BLOCK STMT
     |
     ;

STMT_NO_BLOCK : DECLR ';'
              | ASSGN ';'
              ;

BLOCK : '{'
{
    scope++;   // enter block scope
}
STMT
'}'
{
    scope--;   // exit block scope
}
;

COND : EXPR
     | ASSGN
     ;

%%

void yyerror(char* s)
{
    printf("Error : %s at line %d\n", s, yylineno);
}

int main()
{
    t = allocate_space_for_table();   // initialize symbol table
    yyparse();
    display_symbol_table();           // print table
    return 0;
}