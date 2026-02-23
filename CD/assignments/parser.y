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
%token IF ELSE DO WHILE FOR
%token SWITCH CASE DEFAULT BREAK
%token ID NUM
%token EQ NE GE LE GT LT
%token AND INC

/* Operator precedence */
%left AND
%left GT LT GE LE EQ NE
%left '+' '-'
%left '*' '/'
%right '='
%right INC

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
    | BREAK ';'
    ;



/* ---------------- DECLARATIONS ---------------- */

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
      declarator
    | declarator_list ',' declarator
    ;

declarator:
      ID
    | ID '=' expression
    | ID array_dims
    | ID array_dims '=' expression
    ;

array_dims:
      '[' NUM ']'
    | array_dims '[' NUM ']'
    ;


/* ---------------- EXPRESSIONS ---------------- */

expression_stmt:
    expression ';'
    ;

expression_list:
      expression
    | expression_list ',' expression
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
    | expression AND expression
    | ID INC
    | '(' expression ')'
    | ID
    | NUM
    ;


/* ---------------- IF / SWITCH ---------------- */

selection_stmt:
      IF '(' expression ')' statement %prec LOWER_THAN_ELSE
    | IF '(' expression ')' statement ELSE statement
    | SWITCH '(' expression ')' '{' case_list '}'
    ;

case_list:
      case_list case_stmt
    | case_stmt
    ;

case_stmt:
      CASE NUM ':' program BREAK ';'
    | DEFAULT ':' program
    ;


/* ---------------- LOOPS ---------------- */

iteration_stmt:
      DO statement WHILE '(' expression ')' ';'
    | WHILE '(' expression ')' statement
    | FOR '(' for_init ';' expression ';' for_update ')' statement
    ;

for_init:
      expression_list
    | /* empty */
    ;

for_update:
      expression_list
    | /* empty */
    ;


/* ---------------- BLOCK ---------------- */

compound_stmt:
    '{' program '}'
    ;

%%

void yyerror(const char *s)
{
    printf("Syntax error at line %d, token '%s': %s\n", line_no, yytext, s);
}

int main()
{
    if (yyparse() == 0)
        printf("Syntax valid.\n");
    return 0;
}