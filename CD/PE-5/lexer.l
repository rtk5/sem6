%option noyywrap

%{
#include "ast.h"
#include "parser.tab.h"
#include <stdlib.h>
#include <string.h>
%}

%%

[0-9]+ {
    yylval.str = strdup(yytext);
    return NUM;
}

[ \t]+    ;          /* ignore whitespace */

\n        return '\n';

"+"       return '+';
"-"       return '-';
"*"       return '*';
"/"       return '/';
"("       return '(';
")"       return ')';

. {
    printf("Invalid character: %s\n", yytext);
}

%%
