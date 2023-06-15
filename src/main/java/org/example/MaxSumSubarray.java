package org.example;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSumSubarray {
    public int maxProduct(int[] nums) {
        int start = 0;
        int end = nums.length;
        return DAC_MAX(nums, start, end);
    }

    private int DAC_MAX(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        if (start > end) {
            return Integer.MIN_VALUE;
        }

        int middle = (start + end) / 2;

        return Math.max(
                maxSum(nums, start, end, middle),
                Math.max(DAC_MAX(nums, start, middle - 1), DAC_MAX(nums, middle + 1, end))
        );

    }

    private int maxSum(int[] nums, int start, int end, int middle) {
        int left_mult = Integer.MIN_VALUE;
        int right_mult = Integer.MIN_VALUE;
        int full = Integer.MIN_VALUE;

        log.debug("start={}, end={}, middle={}", new Object[]{start, end, middle});
        int mult = 1;
        for (int i = middle; i >= start; i--) {
            //if (nums[i] == 0) break;
            mult *= nums[i];
            left_mult = Math.max(mult, left_mult);
        }
        log.debug("left={}", left_mult);

        //max_left * shift to right
        mult = left_mult;
        for (int i = middle+1; i<=end; i++) {
            //if (nums[i] == 0) break;
            mult *= nums[i];
            left_mult = Math.max(mult, left_mult);
        }

        mult = 1;
        for (int i = middle; i <= end; i++) {
            //if (nums[i] == 0) break;
            mult *= nums[i];
            right_mult = Math.max(mult, right_mult);
        }

        log.debug("right={}", right_mult);

        //max_right * shift to left
        mult = right_mult;
        for (int i = middle-1; i>=start; i--) {
            //if (nums[i] == 0) break;
            mult *= nums[i];
            right_mult = Math.max(mult, right_mult);
        }

        mult = 1;
        for (int i = start; i <= end; i++) {
            mult *= nums[i];
            full = Math.max(mult, full);
        }

        mult = 1;
        for (int i = end; i >= start; i--) {
            mult *= nums[i];
            full = Math.max(mult, full);
        }

        log.debug("left={}, right={}, full={}", new Object[]{left_mult, right_mult, full});
        return Math.max(full,
                Math.max(left_mult, right_mult));
    }
}
