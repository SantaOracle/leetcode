package main.java.com.shijx5514.leetcode;


/**
 * lc27
 * @author shijiaxin02
 * @date 2019/06/05
 */
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            if(val != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveElement27 removeElement27 = new RemoveElement27();
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        removeElement27.removeElement(nums , val);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
