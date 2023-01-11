package com.example.testexpression;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@SpringBootApplication
public class TestExpressionApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestExpressionApplication.class, args);
    }

    @Override
    public void run(String... args) {
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("x", 2000);

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("#x/10");
        System.out.println(expression.getValue(evaluationContext));
    }
}
