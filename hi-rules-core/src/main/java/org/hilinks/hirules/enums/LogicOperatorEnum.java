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
package org.hilinks.hirules.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 逻辑运算符枚举
 */
@Getter
public enum LogicOperatorEnum {
    AND("&&"),
    OR("||");

    private final String expression;

    LogicOperatorEnum(String expression) {
        this.expression = expression;
    }

    // 自定义反序列函数
    // JsonCreator.Mode.DELEGATING： 接收单个值，将接收的值整个传入自定义函数
    // @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    // public static LogicOperatorEnum get(String expression) {
    //     if (!StringUtils.hasLength(expression)) return null;
    //     return Arrays.stream(LogicOperatorEnum.values()).filter(i -> i.getExpression().equals(expression)).findAny().orElse(null);
    // }

    public static List<String> all() {
        return Arrays.stream(LogicOperatorEnum.values()).map(LogicOperatorEnum::getExpression).collect(Collectors.toList());
    }
}
