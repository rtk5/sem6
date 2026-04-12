%{
#include "parser.tab.h"
#include <string.h>
%}

%%

"if"        { return IF; }
"else"      { return ELSE; }
"do"        { return DO; }
"while"     { return WHILE; }
"<="        { return LE; }
">="        { return GE; }
"=="        { return EQ; }
"!="        { return NE; }
"<"         { return LT; }
">"         { return GT; }
"="         { return ASSIGN; }
"+"         { return PLUS; }
"-"         { return MINUS; }
"*"         { return MUL; }
"/"         { return DIV; }
"("         { return LPAREN; }
")"         { return RPAREN; }
"{"         { return LBRACE; }
"}"         { return RBRACE; }
";"         { return SEMICOLON; }

[a-zA-Z_][a-zA-Z0-9_]* {
    yylval.str = strdup(yytext);
    return T_ID;
}

[0-9]+(\.[0-9]+)? {
    yylval.str = strdup(yytext);
    return T_NUM;
}

[ \t\n\r]+  { /* skip whitespace */ }
.           { /* ignore unknown */ }

%%

int yywrap() { return 1; }
