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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StrNumServiceTest {

    @InjectMocks
    StrNumService strNumService;

    @Test
    public void equalPositiveNumbers() {
        int result = strNumService.cmp("123", "123");
        assertEquals(result, 0);
    }

    @Test
    public void equalZero() {
        int result = strNumService.cmp("0", "0");
        assertEquals(result, 0);
    }

    @Test
    public void equalNegativeNumbers() {
        int result = strNumService.cmp("-123", "-123");
        assertEquals(result, 0);
    }
}
