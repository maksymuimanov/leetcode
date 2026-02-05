package easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result++] = nums[i];
            }
        }
        return result;
    }

    public static void main() {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
