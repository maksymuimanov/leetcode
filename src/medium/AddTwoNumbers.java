package medium;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val + (next == null ? "" : ", " + next);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode iterated = result;
        boolean carry = false;
        while (l1 != null || l2 != null || carry) {
            if (l1 == null && l2 == null) {
                iterated.next = new ListNode(1);
                carry = false;
            } else {
                int carryValue = carry ? 1 : 0;
                if (l1 == null) {
                    int val = l2.val + carryValue;
                    iterated.next = new ListNode(val % 10);
                    l2 = l2.next;
                    carry = val >= 10;
                } else if (l2 == null) {
                    int val = l1.val + carryValue;
                    iterated.next = new ListNode(val % 10);
                    l1 = l1.next;
                    carry = val >= 10;
                } else {
                    int sum = l1.val + l2.val + carryValue;
                    iterated.next = new ListNode(sum % 10);
                    carry = sum >= 10;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }

            iterated = iterated.next;
        }


        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(1, new ListNode(2, new ListNode(3))), new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(1, new ListNode(0, new ListNode(1))), new ListNode(1, new ListNode(2))));
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(1, new ListNode(9, new ListNode(9))), new ListNode(1, new ListNode(2))));
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9))), new ListNode(1)));
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9))), new ListNode(0)));
    }
}
