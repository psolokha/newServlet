package ru.appline.logic;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import lombok.Getter;
import lombok.Setter;

public class Calc {
	
	@Setter
	public String a;
	@Setter
	public String b;
	@Setter
	public String math;
	@Getter @Setter
	private String result;
	
	public Calc (String a, String b, String math) {
		this.a = a;
		this.b = b;
		this.math = math;
		ExpressionParser parser = new SpelExpressionParser();
		this.result = String.valueOf(parser.parseExpression(a+math+b).getValue());
	}
}
