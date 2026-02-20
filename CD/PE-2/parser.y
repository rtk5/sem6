%{
#include <stdio.h>
#include <stdlib.h>

extern int yylex();
extern int line_no;
extern char *yytext;

void yyerror(const char *s);
%}

/* Tokens */
%token INT FLOAT CHAR DOUBLE
%token IF ELSE DO WHILE
%token ID NUM
%token EQ NE GE LE GT LT

/* Operator precedence */
%left '+' '-'
%left '*' '/'
%left GT LT GE LE EQ NE
%right '='

/* Fix dangling else */
%nonassoc LOWER_THAN_ELSE
%nonassoc ELSE

%%

program:
      program statement
    | /* empty */
    ;

statement:
      declaration
    | expression_stmt
    | selection_stmt
    | iteration_stmt
    | compound_stmt
    ;

declaration:
    type declarator_list ';'
    ;

type:
      INT
    | FLOAT
    | CHAR
    | DOUBLE
    ;

declarator_list:
      ID
    | declarator_list ',' ID
    ;

expression_stmt:
    expression ';'
    ;

selection_stmt:
      IF '(' expression ')' statement %prec LOWER_THAN_ELSE
    | IF '(' expression ')' statement ELSE statement
    ;

iteration_stmt:
    DO statement WHILE '(' expression ')' ';'
    ;

compound_stmt:
    '{' program '}'
    ;

expression:
      ID '=' expression
    | expression '+' expression
    | expression '-' expression
    | expression '*' expression
    | expression '/' expression
    | expression GT expression
    | expression LT expression
    | expression GE expression
    | expression LE expression
    | expression EQ expression
    | expression NE expression
    | '(' expression ')'
    | ID
    | NUM
    ;

%%

void yyerror(const char *s) {
    printf("Syntax error at line %d, token '%s': %s\n", line_no, yytext, s);
}

int main() {
    if (yyparse() == 0)
        printf("Syntax valid.\n");
    return 0;
}