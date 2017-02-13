package com.talipov;

/**
 * Created by Марсель on 13.02.2017.
 */
public class Storage {
    private volatile boolean[] nums;
    private volatile short count;

    public Storage(int maxCount) {
        this.nums = new boolean[maxCount];
        for (int i = 0; i < this.nums.length; i++) {
            this.nums[i] = false;
        }
    }

    public boolean putNum(int num) {
        if (!nums[num]) {
            nums[num] = true;
            count++;
        }

        return count != nums.length ;
    }

    public int getCount() {
        return count;
    }
}
