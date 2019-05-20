package com.foo.test.spel;

import java.util.List;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author fooisart
 * @date 10:48 20-05-2019
 */
public class SpelTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        String expression = "'aa' + 'bb'";
        Object value = parser.parseExpression(expression).getValue();
        System.out.println(value);

        String expression1 = "{1,2,3}";
        Object value1 = parser.parseExpression(expression1).getValue(List.class);
        System.out.println(value1);
    }
}
