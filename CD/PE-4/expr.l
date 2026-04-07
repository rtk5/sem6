%{
#include "expr.tab.h"
#include <stdlib.h>
#include <string.h>
%}

%%
[0-9]+      { yylval.num = atoi(yytext); return NUMBER; }

[a-zA-Z]+   { yylval.id = strdup(yytext); return ID; }

","         return COMMA;
"="         return EQUAL;
"+"         return PLUS;
"-"         return MINUS;
"*"         return MUL;
"/"         return DIV;

"("         return '(';
")"         return ')';

[ \t]       ;        /* ignore spaces and tabs */
\n          return '\n';   /* IMPORTANT: signals end of input */

.           { printf("Invalid character: %s\n", yytext); }

%%
