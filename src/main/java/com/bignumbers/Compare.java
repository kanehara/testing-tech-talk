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

import java.util.ArrayList;
import java.util.List;

@Component
public class Compare {
    @Autowired
    StrNumService strNumService;

    public String getComparisonStatement(String a, String b) {
        int result = strNumService.cmp(a, b);
        if (result == 0) {
            return "The numbers are equal!";
        } else if (result == 1) {
            return "The first number is larger!";
        } else if (result == -1) {
            return "The second number is larger!";
        }
        return "Invalid comparison";
    }

    /**
     * Compares each pair in pairList and returns an array of integers of the pair comparisions.
     * For lists with odd number of string's, the comparison should return 1 for that pair
     *
     * Ex) ["1", "0", "0", "1"] -> [1, 0]
     *     ["1", "0", "0", "1", "2"] -> [1, 0, 1]
     */
    public List<Integer> getComparisonPairList(List<String> pairList) {
        List<Integer> comparisonPairList = new ArrayList<Integer>();
        for (int i = 0; i < pairList.size(); i += 2) {
            if ((i + 1) >= pairList.size()) {
                comparisonPairList.add(1);
            } else {
                String a = pairList.get(i);
                String b = pairList.get(i + 1);
                int result = strNumService.cmp(a, b);
                comparisonPairList.add(result);
            }
        }
        return comparisonPairList;
    }
}
