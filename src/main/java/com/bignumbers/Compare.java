/*
 * Copyright (c) 2016. Vodori, Inc.  All rights reserved.
 *
 * This software is not open source and license for its use and
 * modification can only be granted through an agreement with
 * Vodori, Inc.
 *
 * http://www.vodori.com
 *
 * Created by yohei.kanehara on 7/4/17.
 */
package com.bignumbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Compare {
    @Autowired
    StrNumService strNumService;

    public String getComparisonStatement() {
        int result = strNumService.cmp("123", "1");
        if (result == 0) {
            return "The numbers are equal!";
        } else if (result == 1) {
            return "The first number is larger!";
        } else if (result == -1) {
            return "The second number is larger!";
        }
        return "Invalid comparison";
    }
}
