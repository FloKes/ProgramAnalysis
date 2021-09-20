grammar MicroC;

LPAREN : '(';
RPAREN: ')';
LBRACE : '{';
RBRACE : '}';
SEMI : ';';
LBRACKET : '[';
RBRACKET : ']';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
GT : '>';
GE : '>=';
LT : '<';
LE : '<=';
EQ : '==';
NEQ : '!=';
NOT : '!';
AND : '&';
OR : '|';
COMMA : ',';
ELSE : 'else';
FST : '.fst';
SND : '.snd';
INT : 'int';
EQUAL : ':=';
READ : 'read';
WRITE : 'write';
IF : 'if';
WHILE : 'while';
R : 'R';

program: LBRACE decl statement RBRACE;
blockStmnt: LBRACE (decl | statement) RBRACE;

statement
    : (ifElse
    | lAssign
    | recordAssign
    | whileStmnt
    | readStmnt
    | writeStmnt)*
    ;

ifElse: IF LPAREN bexpr RPAREN blockStmnt (elseStmnt)?;
elseStmnt: ELSE blockStmnt;
lAssign: lexpr EQUAL rexpr SEMI;
recordAssign:  R EQUAL LPAREN rexpr COMMA rexpr RPAREN SEMI;
whileStmnt: WHILE LPAREN bexpr RPAREN blockStmnt;
readStmnt:READ lexpr SEMI;
writeStmnt:WRITE rexpr SEMI;
lexpr: IDENTIFIER array
    | IDENTIFIER
    | (R)FST
    | (R)SND
    ;

rexpr: rexpr opa rexpr
    | INTEGER
    | IDENTIFIER array
    | IDENTIFIER
    | (R)FST
    | (R)SND
    ;

array: LBRACKET (INTEGER|IDENTIFIER) RBRACKET ;

bexpr: rexpr opr rexpr
    | bexpr opb bexpr
    | TRUE
    | FALSE
    | NOT bexpr
    ;

decl: (varDecl
    | arrayDecl
    | recordDecl
    )*
    ;

varDecl: INT IDENTIFIER (SEMI)?;
arrayDecl: INT LBRACKET INTEGER RBRACKET IDENTIFIER SEMI;
recordDecl: blockStmnt R SEMI;

opa: PLUS
    | MINUS
    | MULT
    | DIV
    | MOD
    ;

opr: GT
    | LT
    | GE
    | LE
    | EQ
    | NEQ
    ;


opb: AND
    | OR
    ;

INTEGER : ('0' | '1'..'9' '0'..'9'*);
IDENTIFIER : LETTER (LETTER|'0'..'9')* ;
fragment
LETTER : 'A'..'Z'
       | 'a'..'z'
       | '_'
       ;

COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : (' '|'\r'|'\t'|'\u000C'|'\n') -> skip ;
