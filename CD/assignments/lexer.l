%{
#include "parser.tab.h"
#include <stdio.h>
#include <stdlib.h>

int line_no = 1;
%}

%%

/* Data types */
int             { return INT; }
float           { return FLOAT; }
char            { return CHAR; }
double          { return DOUBLE; }

/* Keywords */
if              { return IF; }
else            { return ELSE; }
do              { return DO; }
while           { return WHILE; }
for             { return FOR; }
switch          { return SWITCH; }
case            { return CASE; }
default         { return DEFAULT; }
break           { return BREAK; }

/* Operators */
"=="            { return EQ; }
"!="            { return NE; }
">="            { return GE; }
"<="            { return LE; }
">"             { return GT; }
"<"             { return LT; }
"&&"            { return AND; }
"++"            { return INC; }

"+"             { return '+'; }
"-"             { return '-'; }
"*"             { return '*'; }
"/"             { return '/'; }
"="             { return '='; }

/* Symbols */
";"             { return ';'; }
","             { return ','; }
":"             { return ':'; }
"("             { return '('; }
")"             { return ')'; }
"{"             { return '{'; }
"}"             { return '}'; }
"["             { return '['; }
"]"             { return ']'; }

/* Identifiers and numbers */
[0-9]+          { return NUM; }
[a-zA-Z_][a-zA-Z0-9_]*    { return ID; }

/* Whitespace */
[ \t\r]+        ;
\n              { line_no++; }

/* Any other character */
.               { return yytext[0]; }

%%

int yywrap(void)
{
    return 1;
}