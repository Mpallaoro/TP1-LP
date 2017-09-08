package interpreter.expr;

import interpreter.expr.*;
import interpreter.value.*;

public class FunctionExpr {
	private FunctionType type;
	private Expr param;
	
	public FunctionExpr (FunctionType type, Expr param, int line){
		super(line);
		this.type = type;
		this.param = param;
	}
	
	
	public Value<?> expr(){
		switch(this.type) {
			case Input:
				return;
		}
	}
	
	private Value <?> inputExpr(){
		
	}
}
