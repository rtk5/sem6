%option noyywrap

%{
#include "parser.tab.h"
#include <stdlib.h>
#include <string.h>
%}

%%

[a-zA-Z][a-zA-Z0-9]* {
    yylval.str = strdup(yytext);
    return ID;
}

[0-9]+ {
    yylval.str = strdup(yytext);
    return NUM;
}

[ \t]+    ;

\n        return '\n';

"="       return '=';
"+"       return '+';
"-"       return '-';
"*"       return '*';
"/"       return '/';
"("       return '(';
")"       return ')';

. {
    printf("Invalid char: %s\n", yytext);
}

%%
