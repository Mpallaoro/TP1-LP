package lexical;

import java.util.Map;
import java.util.HashMap;

class SymbolTable {

    private Map<String, TokenType> st;

    public SymbolTable() {
        st = new HashMap<String, TokenType>();
        st.put("=", TokenType.ASSIGN);
        st.put(";", TokenType.DOT_COMMA);
        st.put(",", TokenType.COMMA);
        st.put("{", TokenType.OPEN_CUR);
        st.put("}", TokenType.CLOSE_CUR);
        st.put("(", TokenType.OPEN_PAR);
        st.put(")", TokenType.CLOSE_PAR);
        st.put("[", TokenType.OPEN_BRA);
        st.put("]", TokenType.CLOSE_BRA);
        st.put("=>", TokenType.BIND);
        st.put("print", TokenType. PRINT);
        st.put("println", TokenType.PRINTLN);
        st.put("push", TokenType.PUSH);
        st.put("unshift", TokenType.UNSHIFT);
        st.put("if", TokenType.IF);
        st.put("else", TokenType.ELSE);
        st.put("while", TokenType.WHILE);
        st.put("do", TokenType.DO);
        st.put("foreach", TokenType.FOREACH);
        st.put("and", TokenType.AND);
        st.put("or", TokenType.OR);
        st.put("input", TokenType.INPUT);
        st.put("size", TokenType.SIZE);
        st.put("sort", TokenType.SORT);
        st.put("reverse", TokenType.REVERSE);
        st.put("keys", TokenType.KEYS);
        st.put("values", TokenType.VALUES);
        st.put("pop", TokenType.POP);
        st.put("shift", TokenType.SHIFT);
        st.put("==", TokenType.EQUAL);
        st.put("!=", TokenType.DIFF);
        st.put("<", TokenType.LESS);
        st.put(">", TokenType.GREATER);
        st.put("<=", TokenType.LESS_EQ);
        st.put(">=", TokenType.GREATER_EQ);
        st.put(".", TokenType.CONCATENATE);
        st.put("+", TokenType.PLUS);
        st.put("-", TokenType.MINUS);
        st.put("*", TokenType.TIMES);
        st.put("/", TokenType.DIV);
        st.put("%", TokenType.MOD);
        st.put("!", TokenType.NOT);
        st.put(" ", TokenType.EMPTY);
        // FIXME: Add the tokens here.
        // st.put("???", TokenType.???);
    }

    public boolean contains(String token) {
        return st.containsKey(token);
    }

    public TokenType find(String token) {
        return this.contains(token) ?
            st.get(token) : TokenType.INVALID_TOKEN;
    }
}
