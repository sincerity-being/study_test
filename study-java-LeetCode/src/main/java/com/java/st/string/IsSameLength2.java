package com.java.st.string;/**
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
public class IsSameLength2 {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, ans = 0;
        // 索引值 窗口移动.
        Map<Character, Integer> strMap = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (strMap.containsKey(c)) {
                start = Math.max(strMap.get(c), start);
            }
            ans = Math.max(end - start + 1, ans);
            // 没有就新增 , 有就更新
            strMap.put(c, end + 1);
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        IsSameLength2 isSameLength2 = new IsSameLength2();
        int ans = isSameLength2.lengthOfLongestSubstring("dvdf");
        log.debug("ans:{}", ans);
    }

}
