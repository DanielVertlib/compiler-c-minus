/*
  Created By: Fei Song
  Modified By: Daniel Vertlib & Ryan Rudzitis
  File Name: tiny.flex
  To Build: jflex tiny.flex

  and then after the parser is created
    javac Lexer.java
*/

/* --------------------------Usercode Section------------------------ */

import java_cup.runtime.*;

%%

/* -----------------Options and Declarations Section----------------- */

// Name of class JFlex creates Lexer, code written to Lexer.java
%class Lexer

// Done scanning, end of file
%eofval{
  return null;
%eofval};

// Variables yyline (current line number) and yycolumn (current column number)
%line
%column

// Switch to CUP compatibility mode to interface with a CUP generated parser
%cup

// Functions to create new java_cup.runtime.Symbol
%{
    // Token has no value
    private Symbol symbol(int type) {
      Symbol test = new Symbol(type, yyline, yycolumn);
      System.out.println(test);
      return test;
    }

    // Token has value
    private Symbol symbol(int type, Object value) {
        Symbol test = new Symbol(type, yyline, yycolumn, value);
        System.out.println(test);
        return test;
    }
%}

/*---------- Macro Declarations for Regular Expressions Section ------ */

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
digit = [0-9]
number = {digit}+
letter = [a-zA-Z]
identifier = {letter}+

%%
/* ----------- Lexical Rules for C-Minus Language Section ------------- */

/* Keywords */
"if"               { return symbol(sym.IF); }
"else"             { return symbol(sym.ELSE); }
"while"            { return symbol(sym.WHILE); }
"return"           { return symbol(sym.RETURN); }
"void"             { return symbol(sym.VOID); }
"int"              { return symbol(sym.INT); }

/* Symbols */
"="                { return symbol(sym.ASSIGN); }
"=="               { return symbol(sym.EQ); }
"!="               { return symbol(sym.NE); }
"<"                { return symbol(sym.LT); }
"<="               { return symbol(sym.LE); }
">"                { return symbol(sym.GT); }
">="               { return symbol(sym.GE); }
"+"                { return symbol(sym.PLUS); }
"-"                { return symbol(sym.MINUS); }
"*"                { return symbol(sym.MUL); }
"/"                { return symbol(sym.DIV); }
"("                { return symbol(sym.LPAREN); }
")"                { return symbol(sym.RPAREN); }
"{"                { return symbol(sym.LBRACE); }
"}"                { return symbol(sym.RBRACE); }
"["                { return symbol(sym.LBRACKET); }
"]"                { return symbol(sym.RBRACKET); }
";"                { return symbol(sym.SEMI); }
","                { return symbol(sym.COMMA); }

/* All other tokens, including invalid characters */
{WhiteSpace}*      { /* skip whitespace */ }
{identifier}       { return symbol(sym.ID, yytext()); }
{number}           { return symbol(sym.NUM, yytext()); }
.                  { return symbol(sym.ERROR); }
"{"[^\}]*"}"       { /* skip comments */ }
