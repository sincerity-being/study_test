package com.study.leetcode.algorithm.st.string;/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd.
 */


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author hyq  heyuqiang@kungeek.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */

@Slf4j
public class IsSameLength {

    /**
     * 部分可以 其他不行 eg: "dvdf"
     *
     * @param s 字符串s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, ans = 0;
        Map<Character, Integer> strMap = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (strMap.containsKey(c)) {
                start = Math.max(end, start);
                strMap.put(c, end);
            }
            strMap.put(c, end);
            ans = Math.max(end - start + 1, ans);
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        IsSameLength isSameLength = new IsSameLength();
        // String s = "abcabcbb";
        String s = "bbbbb";
        int ans = isSameLength.lengthOfLongestSubstring(s);
        log.info("ans:{}", ans);
    }
}
