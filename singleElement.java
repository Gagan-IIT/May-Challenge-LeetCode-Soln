/* Problem:
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10

Note: Your solution should run in O(log n) time and O(1) space.
*/


class Solution {
    public int singleNonDuplicate(int[] nums) {
        return search(nums, 0, nums.length-1);
    }
    
    public int search(int[] nums, int s, int e){
        if(s==e) return nums[s];
        if(e-s==1){
            if(s-1>0 && nums[s-1]==nums[s]) return nums[e];
            if(e+1<nums.length && nums[e+1]==nums[e]) return nums[s];
        }
        int mid = s+ (e-s)/2;
        if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]) return nums[mid];
        if(mid%2==0){
            if(nums[mid]==nums[mid-1]) return search(nums, s, mid);
            else return search(nums, mid+1, e);
        }else{
            if(nums[mid]!=nums[mid-1]) return search(nums, s, mid);
            else return search(nums, mid+1, e);
        }
    }
}
