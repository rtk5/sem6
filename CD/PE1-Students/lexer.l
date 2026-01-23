%{
#include <stdio.h>
#include <string.h>
#include "y.tab.h"

int line_no = 1;
void yyerror(const char *s);
%}

/* ---------- Regular Definitions ---------- */
digit       [0-9]
letter      [a-zA-Z]
id          {letter}({letter}|{digit})*
number      {digit}+
ws          [ \t]+

%%
/* ---------- Keywords ---------- */
"int"           { return INT; }
"float"         { return FLOAT; }
"double"        { return DOUBLE; }
"char"          { return CHAR; }

"if"            { return IF; }
"else"          { return ELSE; }
"while"         { return WHILE; }
"for"           { return FOR; }
"do"            { return DO; }

"main"          { return MAIN; }
"#include"      { return INCLUDE; }

/* ---------- Relational Operators ---------- */
"=="            { return EQCOMP; }
">="            { return GREATEREQ; }
"<="            { return LESSEREQ; }
"!="            { return NOTEQ; }

/* ---------- Logical Operators ---------- */
"&&"            { return ANDAND; }
"||"            { return OROR; }
"!"             { return '!'; }

/* ---------- Increment / Decrement ---------- */
"++"            { return INC; }
"--"            { return DEC; }

/* ---------- Identifiers & Literals ---------- */
{id}            { return ID; }
{number}        { return NUM; }

\"([^\"\n])*\"  { return STRLITERAL; }
\<[a-zA-Z0-9_.]+\.h\> { return HEADER; }

/* ---------- Single-character Tokens ---------- */
"("             { return '('; }
")"             { return ')'; }
"{"             { return '{'; }
"}"             { return '}'; }
"["             { return '['; }
"]"             { return ']'; }
";"             { return ';'; }
","             { return ','; }
"="             { return '='; }
"+"             { return '+'; }
"-"             { return '-'; }
"*"             { return '*'; }
"/"             { return '/'; }

/* ---------- Whitespace & Newlines ---------- */
/* ---------- Comments ---------- */
{ws}            { /* ignore spaces & tabs */ }
\n              { line_no++; }

"//".*          { /* single-line comment */ }
\/\*([^*]|\*+[^*/])*\*+\/   { /* multi-line comment */ }


/* ---------- Invalid Characters ---------- */
. {
    printf("Lexical error: %s at line %d\n", yytext, line_no);
}

%%
int yywrap() {
    return 1;
}
