package lexical;

public enum TokenType {
	// special tokens
    INVALID_TOKEN,
    UNEXPECTED_EOF,
    END_OF_FILE,

    // symbols
    // ...
    ASSIGN,         // =
    DOT_COMMA,      // ;
    COMMA,          // ,
    OPEN_CUR,       // {
    CLOSE_CUR,      // }
    OPEN_PAR,       // (
    CLOSE_PAR,      // ) 
    OPEN_BRA,       // [
    CLOSE_BRA,      // ]
    BIND,           // => 
    // keywords
    // ...
    PRINT,          // print
    PRINTLN,        // println
    PUSH,           // push
    UNSHIFT,        // unshift
    IF,             // if
    ELSE,           // else
    WHILE,          // while
    DO,             // do
    FOREACH,        // foreach 
    AND,            // and
    OR,             // or
    INPUT,          // input
    SIZE,           // size
    SORT,           // sort
    REVERSE,        // reverse
    KEYS,           // keys
    VALUES,         // values
    POP,
    SHIFT,
    // operators
    // ...
    EQUAL,          // ==
    DIFF,           // !=
    LESS,           // <
    GREATER,        // >
    LESS_EQ,        // <=
    GREATER_EQ,     // >=
    CONCATENATE,    // .
    PLUS,           // +
    MINUS,          // -
    TIMES,          // *
    DIV,            // /
    MOD,            // %
    NOT,
    // others
    // ...
    NUMBER,         //
    STRING,         //
    SVAR,           // variavel
    LVAR,           // lista
    HVAR,           // hash
    EMPTY
};
