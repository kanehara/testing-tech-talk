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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompareTest {
    @InjectMocks
    Compare compare;

    @Mock
    StrNumService strNumService;

    @Before
    public void setup() {
        when(strNumService.cmp(anyString(), anyString())).thenCallRealMethod();
//        when(strNumService.strip(anyString())).thenCallRealMethod();
    }

    @Test
    public void getComparisonStatement() {
        String result = compare.getComparisonStatement();
        assertEquals(result, "The first number is larger!");
    }
}
