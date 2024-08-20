/*
 * The MIT License
 *
 *  Copyright (c) 2024, joe
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package org.hilinks.hirules.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Facts;

/**
 * AviatorScript 动作脚本解析器
 */
@Slf4j
public class AviatorAction implements Action {

    private final String expression;
    private final Expression compiledExpression;

    public AviatorAction(String expression) {
        this.expression = expression;
        this.compiledExpression = AviatorEvaluator.getInstance().compile(expression,true);
    }

    /**
     * Execute the action when the rule's condition evaluates to true.
     *
     * @param facts known at the time of execution of the action
     * @throws Exception when unable to execute the action
     */
    @Override
    public void execute(Facts facts) throws Exception {
        try {
            compiledExpression.execute(facts.asMap());
        } catch (Exception e) {
            log.error("Unable to evaluate expression: '{}' on facts: {}", expression, facts, e);
            throw e;
        }
    }
}
