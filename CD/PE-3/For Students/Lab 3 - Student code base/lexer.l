%{
#include "y.tab.h"
#include <string.h>

int yycolumn = 1;
#define YY_USER_ACTION yycolumn += yyleng;
%}

%option yylineno

digit   [0-9]
letter  [a-zA-Z]
id      {letter}({letter}|{digit})*
digits  {digit}+

%%

"static"   { return T_STATIC; }
"extern"   { return T_EXTERN; }
"register" { return T_REGISTER; }

"int"      { return T_INT; }
"float"    { return T_FLOAT; }
"char"     { return T_CHAR; }
"double"   { return T_DOUBLE; }

"main"     { return T_MAIN; }

{id}       { yylval.str = strdup(yytext); return T_ID; }
{digits}   { yylval.str = strdup(yytext); return T_NUM; }

"(" { return *yytext; }
")" { return *yytext; }
"{" { return *yytext; }
"}" { return *yytext; }
";" { return *yytext; }
"," { return *yytext; }
"=" { return *yytext; }

[ \t\n] ;
. ;

%%

int yywrap() { return 1; }