%option noyywrap
%{
	#include<stdio.h>
%}

%%
[\n\t] ;
[a-z]{2}[0-9]@uaeh.edu.mx {printf("email\n");}
%%

int main()
{

printf("Ingrese el email institucional: ");

yylex();
	return 0;
}