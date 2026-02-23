%{
#include "y.tab.h"
#include <stdio.h>
#include <stdlib.h>

int line_no = 1;
%}

%%

int             { return INT; }
float           { return FLOAT; }
char            { return CHAR; }
double          { return DOUBLE; }

if              { return IF; }
else            { return ELSE; }
do              { return DO; }
while           { return WHILE; }
for             { return FOR; }
switch          { return SWITCH; }
case            { return CASE; }
default         { return DEFAULT; }
break           { return BREAK; }

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

";"             { return ';'; }
","             { return ','; }
":"             { return ':'; }
"("             { return '('; }
")"             { return ')'; }
"{"             { return '{'; }
"}"             { return '}'; }
"["             { return '['; }
"]"             { return ']'; }

[0-9]+                  { return NUM; }
[a-zA-Z_][a-zA-Z0-9_]*  { return ID; }

[ \t\r]+        ;
\n              { line_no++; }

.               { return yytext[0]; }

%%

int yywrap(void)
{
    return 1;
}