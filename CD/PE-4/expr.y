%{
#include <stdio.h>
#include <stdlib.h>
#include "symtab.h"

void yyerror(const char *s);
int yylex();
%}

%union {
    int num;
    char *id;
}

%token <num> NUMBER
%token <id> ID
%token PLUS MINUS MUL DIV EQUAL COMMA

%type <num> expr term factor

%%

input:
    stmt_list '\n'
    ;

stmt_list:
    stmt
  | stmt_list COMMA stmt
  ;

stmt:
    ID EQUAL expr {
        update($1, $3);
        printf("%s = %d\n", $1, $3);
    }
    ;

expr:
    expr PLUS term   { $$ = $1 + $3; }
  | expr MINUS term  { $$ = $1 - $3; }
  | term             { $$ = $1; }
  ;

term:
    term MUL factor  { $$ = $1 * $3; }
  | term DIV factor  {
        if($3 == 0) {
            printf("Error: Division by zero\n");
            $$ = 0;
        } else {
            $$ = $1 / $3;
        }
    }
  | factor           { $$ = $1; }
  ;

factor:
    NUMBER           { $$ = $1; }
  | ID               { $$ = getval($1); }
  | '(' expr ')'     { $$ = $2; }   /* optional but recommended */
  ;

%%

void yyerror(const char *s) {
    printf("Parse error: %s\n", s);
}

int main() {
    printf("Enter expression:\n");
    yyparse();

    printf("\nSymbol Table:\n");
    for(int i = 0; i < count; i++) {
        printf("%s = %d\n", table[i].name, table[i].value);
    }

    return 0;
}
