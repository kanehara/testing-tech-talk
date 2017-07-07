/*
 * Copyright (c) 2016. Vodori, Inc.  All rights reserved.
 *
 * This software is not open source and license for its use and
 * modification can only be granted through an agreement with
 * Vodori, Inc.
 *
 * http://www.vodori.com
 *
 * Created by yohei.kanehara on 7/7/17.
 */
package com.bignumbers;

import com.config.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CompareIT {

    private Compare compare;

    @Before
    public void setup() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        compare = context.getBean(Compare.class);
    }

    @Test
    public void getComparisonStatement_a_gt_b() {
        String statement = compare.getComparisonStatement("1", "0");
        assertEquals(statement, "The first number is larger!");
    }

    @Test
    public void getComparisonStatement_a_lt_b() {
        String statement = compare.getComparisonStatement("0", "1");
        assertEquals(statement, "The second number is larger!");
    }

    @Test
    public void getComparisonStatement_a_eq_b() {
        String statement = compare.getComparisonStatement("-1", "-1");
        assertEquals(statement, "The numbers are equal!");
    }

    @Test
    public void getComparisonList_even() {
        List<String> pairList = Arrays.asList("1", "0", "-1", "-2");
        List<Integer> comparisonPairList = compare.getComparisonPairList(pairList);
        List<Integer> expected = Arrays.asList(1, 1);
        assertThat(comparisonPairList, is(expected));
    }

    @Test
    public void getComparisonList_odd() {
        // TODO: fill out odd case
    }
}
