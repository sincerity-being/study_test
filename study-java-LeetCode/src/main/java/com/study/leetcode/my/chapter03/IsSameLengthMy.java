package com.study.leetcode.my.chapter03;/**
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
public class IsSameLengthMy {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end, ans = 0;
        Map<Character, Integer> strMap = new HashMap<>(16);
        // 利用 hash 的 containsKey 移动 start end end 不断增长 start 随机变化
        for (end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (strMap.containsKey(c)) {
                start = Math.max(strMap.get(c), start);
            }
            strMap.put(c, end + 1);
            ans = Math.max(end - start + 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        IsSameLengthMy isSameLengthMy = new IsSameLengthMy();
        int ans = isSameLengthMy.lengthOfLongestSubstring("dvdf");
        log.debug("ans:{}", ans);
    }
}
