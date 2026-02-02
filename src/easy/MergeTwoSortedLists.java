package easy;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        ListNode first = list1;
        ListNode second = list2;
        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) current.next = first;
        else if (second != null) current.next = second;
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            if (next == null) return String.valueOf(val);
            return val + "->" + next;
        }
    }

    public static void main() {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(3, new ListNode(5));
        System.out.println(mergeTwoSortedLists.mergeTwoLists(listNode1, listNode2));
    }
}
