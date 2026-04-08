%{
#include <stdio.h>
#include <stdlib.h>
#include "ast.h"

extern int yylex();
extern FILE *yyin;

void yyerror(const char *s);

Node *root;
FILE *outfile;
%}

%code requires {
    #include "ast.h"
}

%union {
    Node* node;
    char* str;
}

%token <str> NUM
%type <node> expr

%left '+' '-'
%left '*' '/'

%%

input:
      /* empty */
    | input line
;

line:
      expr '\n' {
            root = $1;
            postorder(root);
            fprintf(outfile, "\n");
            freeTree(root);
      }
    | '\n'
;

expr:
      expr '+' expr { $$ = createNode("+", $1, $3); }
    | expr '-' expr { $$ = createNode("-", $1, $3); }
    | expr '*' expr { $$ = createNode("*", $1, $3); }
    | expr '/' expr { $$ = createNode("/", $1, $3); }
    | '(' expr ')'  { $$ = $2; }
    | NUM           { $$ = createNode($1, NULL, NULL); }
;

%%

void yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
}

int main() {
    yyin = fopen("input.txt", "r");
    outfile = fopen("output.txt", "w");

    if (!yyin || !outfile) {
        printf("Error opening file\n");
        return 1;
    }

    yyparse();

    fclose(yyin);
    fclose(outfile);

    printf("Output written to output.txt\n");
    return 0;
}
