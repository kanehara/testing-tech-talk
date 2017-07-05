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

import org.springframework.stereotype.Service;

@Service
public class StrNumService {
    public int cmp(String a, String b) {

        // Case 3: Determine signs
        boolean aPos = a.charAt(0) != '-';
        boolean bPos = b.charAt(0) != '-';
        if (aPos && !bPos) {
            return 1;
        } else if (!aPos && bPos) {
            return -1;
        }

        // Case 2: Trim leading zeros (and later Case 3: strip '-')
        a = strip(a);
        b = strip(b);

        // Case 3: Both pos or both neg (Bonus points for swapping args)
        if (aPos) {
            // Both pos
            return cmpPos(a, b);
        } else {
            // Both neg
            return cmpPos(b, a);
        }
    }

    private int cmpPos(String a, String b) {
        // Case 1: Length comparison
        if (a.length() > b.length()) {
            return 1;
        } else if (a.length() < b.length()) {
            return -1;
        } else {
            // Case 1: Same length, iterate through characters
            for (int i = 0; i < a.length(); i++) {
                // Can compare characters because '0' is less than '1'...
                if (a.charAt(i) > b.charAt(i)) {
                    return 1;
                } else if (a.charAt(i) < b.charAt(i)) {
                    return -1;
                }
            }
            // Case 1: All characters match, they are equal
            return 0;
        }
    }

    public String strip(String s) {
        int i = 0;
        while(i < s.length() - 1) {
            if (s.charAt(i) != '0' && s.charAt(i) != '-')  {
                break;
            }
            i++;
        }

        return s.substring(i);
    }
}
