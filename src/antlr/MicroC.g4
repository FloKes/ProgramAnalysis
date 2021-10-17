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
TRUE : 'true';
FALSE : 'false';

program: LBRACE decl statement RBRACE EOF;

blockStmnt: LBRACE statement RBRACE;

statement
    : (ifElse
    | lAssign
    | recordAssign
    | whileStmnt
    | readStmnt
    | writeStmnt)+
    ;

ifElse: IF LPAREN bexpr RPAREN blockStmnt (elseStmnt)?;
elseStmnt: ELSE blockStmnt;
lAssign: identifierExpr EQUAL valueExpr SEMI;
recordAssign:  IDENTIFIER EQUAL LPAREN valueExpr COMMA valueExpr RPAREN SEMI;
whileStmnt: WHILE LPAREN bexpr RPAREN blockStmnt;
readStmnt:READ identifierExpr SEMI;
writeStmnt:WRITE valueExpr SEMI;

identifierExpr: arrayIndexId
    | varIdentifier
    | recFst
    | recSnd
    ;
valueExpr: identifierExpr #valueIdentifier
    | number #valueNumber
    | valueExpr opa valueExpr #vexprOpAvexpr
    ;

recFst: (IDENTIFIER)FST ;
recSnd: (IDENTIFIER)SND ;
varIdentifier: IDENTIFIER;
arrayIndexId: IDENTIFIER LBRACKET (INTEGER|IDENTIFIER) RBRACKET;
number: INTEGER;


bexpr: valueExpr opr valueExpr #vexprOpRvexpr
    | bexpr opb bexpr #bexprOpBbexpr
    | TRUE #trueTerm
    | FALSE #falseTerm
    | NOT bexpr #notBexpr
    ;

decl: (varDecl
    | arrayDecl
    | recordDecl
    )*
    ;

varDecl: INT IDENTIFIER (EQUAL INTEGER)? (SEMI)?;
arrayDecl: INT LBRACKET INTEGER RBRACKET IDENTIFIER SEMI;
recordDecl: LBRACE varDecl varDecl RBRACE IDENTIFIER SEMI;

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


/* Tokens */

INTEGER : ('0' | '1'..'9' '0'..'9'*);
IDENTIFIER : LETTER (LETTER|'0'..'9')* ;
fragment
LETTER : 'A'..'Z'
       | 'a'..'z'
       | '_'
       ;

COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : (' '|'\r'|'\t'|'\u000C'|'\n') -> skip ;
