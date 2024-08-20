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
package org.hilinks.hirules.core;

import lombok.Data;
import org.hilinks.hirules.enums.SceneEnum;

import java.math.BigDecimal;
import java.util.List;

/**
 * 规则
 */
@Data
public class Conditions {

    private Integer conditionId;

    /**
     * 逻辑运算符（且 &&、或 ||）
     */
    private String logicOperator;

    /**
     * 比较运算符（">"、">="、"<"、"<="、"=="
     */
    private String comparisonOperator;

    /**
     * 数量
     */
    private BigDecimal amount;

    /**
     * 场景
     */
    private SceneEnum scene;

    /**
     * 转换为脚本字符串（忽略最后一个连接符）
     */
    public static String convertRules(List<Conditions> conditions) {
        int lastIndex = conditions.size() - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < conditions.size(); i++) {
            Conditions obj = conditions.get(i);
            result.append(obj.getScene().name()).append(" ");
            result.append(obj.getComparisonOperator()).append(" ");
            result.append(obj.getAmount());
            if (i < lastIndex) {
                result.append(" ").append(obj.getLogicOperator());
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

}
