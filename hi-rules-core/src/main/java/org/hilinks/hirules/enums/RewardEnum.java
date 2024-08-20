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

/**
 * 奖励枚举
 */
@Getter
public enum RewardEnum {

    COUPON("优惠券", "张", 1),
    INTEGRAL("积分", "个", 2),
    MONEY("现金", "元", 3);

    private final String remark;

    /**
     * 计量单位
     */
    private final String unit;

    /**
     * 数据库类型
     */
    private final Integer type;

    public static final String COUPON_CONSTANT = "COUPON";
    public static final String INTEGRAL_CONSTANT = "INTEGRAL";
    public static final String MONEY_CONSTANT = "MONEY";

    RewardEnum(String remark, String unit, Integer type) {
        this.remark = remark;
        this.unit = unit;
        this.type = type;
    }
}
