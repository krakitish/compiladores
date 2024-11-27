%option noyywrap
%{
	#include "y.tab.h"	
%}

%%

[\t\n ]+ ; 

[0-9]+ { return NUM;printf("Numero: %s\n", yytext); }

[*] { return MUL; printf("* : %s\n", yytext);}

. { printf("no reconocido: %s\n", yytext); }
%%

int yywrap() {
    return 1;  
}
