%option noyywrap
%{
#include <stdio.h>
#include <string.h>

extern FILE *yyin;
int num_comentarios = 0;
%}

PALABRAS_RESERVADAS (auto|break|case|char|const|continue|default|delete|do|double|else|enum|extern|float|for|goto|if|inline|int|long|namespace|new|operator|private|protected|public|register|return|short|signed|sizeof|static|struct|switch|template|this|throw|try|typedef|union|unsigned|using|virtual|void|volatile|while)
COMENTARIO (//.*|/\*([^*]|\*+[^/])*\*+/)
VARIABLE [a-zA-Z_][a-zA-Z0-9_]*
NUMERO [0-9]+
ARITMETICOS [+\-*/%]
LOGICOS (\|\||&&|!)
SIMBOLOS [;:()\[\]{}.,#]

%%

{PALABRAS_RESERVADAS}     { printf("Palabra reservada: %s\n", yytext); }
{VARIABLE}                { printf("Variable: %s\n", yytext); }
{NUMERO}                  { printf("Constante numérica: %s\n", yytext); }
{ARITMETICOS}             { printf("Operador aritmético: %s\n", yytext); }
{LOGICOS}                 { printf("Operador lógico: %s\n", yytext); }
{SIMBOLOS}                { printf("Símbolo especial: %s\n", yytext); }
[ \t\n]+                  { /* Ignorar espacios, tabulaciones y saltos de línea */ }
.                         { printf("Carácter desconocido: %s\n", yytext); }

%%

int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Uso: %s <archivo de entrada>\n", argv[0]);
        return 1;
    }

    // Abrir archivo de entrada
    yyin = fopen(argv[1], "r");
    if (!yyin) {
        perror("Error al abrir el archivo");
        return 1;
    }

    // Procesar archivo con Flex
    yylex();

    // Imprimir estadísticas
    printf("Número total de comentarios: %d\n", num_comentarios);

    // Cerrar archivo
    fclose(yyin);

    return 0;
}
