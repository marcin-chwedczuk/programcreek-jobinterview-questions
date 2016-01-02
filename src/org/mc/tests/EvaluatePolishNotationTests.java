package org.mc.tests;

import org.mc.utils.InvalidExpression;
import org.mc.utils.PolishNotationEvaluator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EvaluatePolishNotationTests {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throw_illegal_argument_exception_given_null_expression() {
        PolishNotationEvaluator.eval(null);
    }

    @Test(expectedExceptions = InvalidExpression.class)
    public void throw_invalid_expression_given_expression_that_contain_null_terms() {
        PolishNotationEvaluator.eval(new String[]{"1", null, "+"});
    }

    @Test(expectedExceptions = InvalidExpression.class)
    public void throw_invalid_expression_given_expression_with_missing_operands() {
        PolishNotationEvaluator.eval(new String[]{"1", "+"});
    }

    @Test(expectedExceptions = InvalidExpression.class)
    public void throw_invalid_expression_given_expression_with_redundant_terms() {
        PolishNotationEvaluator.eval(new String[]{"1", "2", "3", "-"});
    }

    @Test(expectedExceptions = InvalidExpression.class)
    public void throw_invalid_expression_given_expression_with_invalid_number() {
        PolishNotationEvaluator.eval(new String[] {"32b"});
    }

    @Test(expectedExceptions = InvalidExpression.class)
    public void throw_invalid_expression_given_expression_with_invalid_operator() {
        PolishNotationEvaluator.eval(new String[] {"3", "54", "?"});
    }

    @Test(dataProvider = "expressions")
    public void given_valid_expression_evaluates_expression_and_returns_result(
            String[] expression, int expectedResult)
    {
        int result = PolishNotationEvaluator.eval(expression);

        Assert.assertEquals(expectedResult, result);
    }

    @DataProvider(name = "expressions")
    public static Object[][] expressionsProvider() {
        return new Object[][] {
                // test number parsing
                {
                        new String[] { "101" },
                        101
                },
                {
                        new String[] { "+101" },
                        101
                },
                {
                        new String[] { "-101" },
                        -101
                },

                // test simple expressions
                {
                        new String[] { "1", "2", "+" },
                        3
                },
                {
                        new String[] { "3", "5", "*" },
                        15
                },
                {
                        new String[] { "5", "7", "-" },
                        -2
                },
                {
                        new String[] { "12", "3", "/" },
                        4
                },

                // test complex expressions
                {
                        new String[] { "3", "5", "7", "+", "*" },
                        36
                },
                {
                        new String[] { "1", "-1", "+", "5", "-" },
                        -5
                },
                {
                        new String[] { "1", "2", "+", "3", "4", "*", "+" },
                        15
                }
        };
    }
}
