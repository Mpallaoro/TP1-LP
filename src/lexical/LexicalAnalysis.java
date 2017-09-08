package lexical;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.PushbackInputStream;

public class LexicalAnalysis implements AutoCloseable {

    private int line;
    private SymbolTable st;
    private PushbackInputStream input;

    public LexicalAnalysis(String filename) throws LexicalException {
        try {
            input = new PushbackInputStream(new FileInputStream(filename));
        } catch (Exception e) {
            throw new LexicalException("Unable to open file");
        }

        st = new SymbolTable();
        line = 1;
    }

    public void close() throws IOException {
        input.close();
    }

    public int getLine() {
        return this.line;
    }

    public Lexeme nextToken() throws IOException {
    	Lexeme lex = new Lexeme("", TokenType.END_OF_FILE);

        int estado = 1;
        while(estado != 12 && estado != 13){
            int c = input.read(); // -1
            
            switch(estado){
                case 1:

                    if(c == '\n'){
                        line++;
                        estado = 1;
                    }
                    else if (c== ' ' || c== '\t' || c== '\r') {
                        estado = 1;
                    }
                    else if (c== '#'){                         
                            estado = 12;
                    }
                    else if (Character.isDigit(c)){                         
                            lex.token += (char) c;
                            lex.type = TokenType.NUMBER;
                            estado = 3;
                    }
                    else if(c=='!'){
                        lex.token += (char) c;
                        estado = 4;
                    }
                    else if(c=='='){
                        lex.token += (char) c;
                        estado = 5;
                    }
                    else if(c=='<' || c=='>'){
                        lex.token += (char) c;
                        estado = 6;
                    }
                    else if(c == ';' || c == ':' || c == '.' || c == ',' || c == '(' ||
        	    			c == ')' || c == '{' || c == '}' || c == '[' || c == ']' ||
        	    			c == '+' || c == '-' || c == '*' || c == '/'){
                        lex.token += (char) c;
                        estado = 12;
                    }
            		
                    else if (Character.isLetter(c)){
                    	lex.token += (char)c;
                    	estado = 7;
                    }
            		
                    //COntinuar 
                    else if(c=='\"'){
                        lex.type = TokenType.STRING;
                        estado = 8;
                    }
                    else if(c=='%'){
                        lex.token += (char) c;
                        estado = 9;
                    }
                     else if(c=='$'){
                        lex.token += (char) c;
                        lex.type = TokenType.SVAR;
                        estado = 10;
                    }
                    else if(c=='@'){
                        lex.token += (char) c;
                        lex.type = TokenType.LVAR;
                        estado = 10;
                    }
                    //se der erro, checar aqui
                    else if(c == -1){
                        estado = 12;
                    }
                    else{
                        lex.token += (char) c;
                        lex.type = TokenType.INVALID_TOKEN;
                        estado = 13;
                    }
                    break;

                case 2:
                    if(c == '\n'){
                        line++;
                        estado = 1;
                    }
                    
                    else
                    	estado = 2;
                    break;

                case 3:
                     if(Character.isDigit(c)){
                        lex.token += (char) c;
                        estado = 3;
                    }
                    else if ( c!= -1 ){
                        input.unread(c);
                        estado = 13;
                    }
                    break;
                    
                case 4:
                    if (c == '=') {
                        lex.token+= (char) c;
                        estado = 12;
                    }
                    else{
                        lex.type=TokenType.INVALID_TOKEN;
                        estado = 13;
                    }
                    break;

                case 5:
                    if (c== '>' || c== '=') {
                        lex.token+= (char) c;
                    }
                    else{
                        if (c!= -1)                         
                            input.unread(c);
                    }
                    
                    estado = 12;
                    break;

                case 6:
                	if (c != '=')
                		if (c != -1)
                			input.unread(c);
                    estado = 12;
                    break;
                	
                case 7:
                    if(Character.isDigit(c) || Character.isLetter(c)){
                        lex.token += (char) c;
                        estado = 7;
                    }

                    else{
                        if(c != -1)
                            input.unread(c);  
                        estado = 12;                  
                    }
                    break;

                case 8:
                	if (c == '\"'){
    	    			lex.token += (char)c;
    	    			estado = 13;
    	    		}
    	    		else
    	    			estado = 8;
                    break;
                    
                case 9:
                	if (Character.isDigit(c) || Character.isLetter(c))
	   	    		 {
	   	    		 	lex.token += (char)c;
	   	    		 	estado = 11;
	   	    		 }
	
	   	    		 else
	   	    		 {
	   	    		 	if (c != -1)
	   	    		 		input.unread(c);
	   	    		 	estado = 12;
	   	    		 }
	   	    		break;
                	
                case 10:
                	if (Character.isDigit(c) || Character.isLetter (c))
    	    		{
    	    		 	lex.token += (char)c;
    	    		 	estado = 11;
    	    		}

    	    		/*else
    	    		{
    		    		if (c != -1)
    		    			input.unread(c);
    		    		estado = 13;
    	    		}*/
    	    		break;
                	
                case 11:
                	if (Character.isDigit(c) || Character.isLetter(c))
    	    		{
    	    			lex.token += (char)c;
    	    		 	estado = 11;
    	    		}

    	    		else
    	    		{
    	    			if (c != -1)
    	    				input.unread(c);
    	    			estado = 13;
    	    		}
            }
        }
        
        if (estado == 12){
        	lex.type = st.find(lex.token);
        }
         // TODO: implement me.

         // HINT: read a char.
         // int c = input.read();

         // HINT: unread a char.
         // if (c != -1)
         //     input.unread(c);

         return lex;
    }
}