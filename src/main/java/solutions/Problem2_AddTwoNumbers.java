package solutions;

public class Problem2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode curr = sum;
        int carry = 0;
        while (carry > 0 || l1 != null || l2 != null) {
            int digitSum = carry;

            if (l1 != null) {
                digitSum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                digitSum += l2.val;
                l2 = l2.next;
            }

            ListNode next = new ListNode();
            next.val = digitSum % 10;
            curr.next = next;
            curr = next;
            carry = digitSum / 10;
        }
        return sum.next;
    }
}
