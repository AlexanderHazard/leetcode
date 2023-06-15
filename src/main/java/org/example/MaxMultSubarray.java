package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxMultSubarray {

    public int maxProduct(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return maxMult(nums, start, end);
    }

    private int maxMult(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        if (start > end) {
            return Integer.MIN_VALUE;
        }

        if (end - start == 1) {
            return Math.max(multArr(nums, start, end),
                    Math.max(nums[start], nums[end])
            );
        }

        int middle = (start + end) / 2;

        return Math.max(multArr(nums, start, end),
                Math.max(maxMult(nums, start, middle), maxMult(nums, middle, end))
        );
    }

    private int multArr(int[] nums, int start, int end) {
        int maxMult = Integer.MIN_VALUE;
        int mult = 1;
        for (int i = start; i <= end; i++) {
            mult *=nums[i];
            maxMult = Math.max(maxMult, mult);
            if (mult == 0) {
                //reset max calculation when 0 found
                mult = 1;
            }
        }

        mult = 1;
        for (int i = end; i >= start; i--) {
            mult *=nums[i];
            maxMult = Math.max(maxMult, mult);
            if (mult == 0) {
                //reset max calculation when 0 found
                mult = 1;
            }
        }

        log.debug("start={}, end={}, maxMult={}", new Object[]{start, end, maxMult});
        return maxMult;
    }
}
