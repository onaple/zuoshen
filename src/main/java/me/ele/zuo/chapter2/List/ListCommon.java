package me.ele.zuo.chapter2.List;

import me.ele.zuo.chapter2.Node;

import java.util.*;

/**
 * Created by onaple on 2017/2/25.
 */
public class ListCommon {

    public static void printCommonPart(Node head1, Node head2) {
        while (null != head1 || null != head2) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static Node removeLastKthNode(Node head, int k) {
        if (null == head || k < 1) {
            return head;
        }

        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (0 == k) {
            head = head.next;
        }

        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (null == head || lastKth < 1) {
            return head;
        }

        DoubleNode cur = head;

        while (cur != null) {
            --lastKth;
            cur = cur.next;
        }

        if (0 == lastKth) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            cur = head;
            while (lastKth != 0) {
                cur = cur.next;
                ++lastKth;
            }


            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }


    public static Node removeMiddleNode(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        if (null == head.next.next) {
            return head.next;
        }

        Node pre = head;
        Node cur = head.next.next;

        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }

        pre.next = pre.next.next;
        return head;
    }

    public static Node revereList(Node head) {
        Node pre = null;
        Node next = null;
        while (null != head) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            pre.last = next;
            head = next;
        }
        return pre;
    }

    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;

        while (node1 != null) {
            len++;
            if (len == from - 1) {
                fPre = node1;
            }
            if (len == to + 1) {
                tPos = node1;
            }
            node1 = node1.next;
        }

        if (from > to || from < 1 || to > len) {
            return head;
        }

        node1 = (fPre == null ? head : fPre.next);//确定反转的头部

        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;

        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if (fPre != null) {
            fPre.next = node1;
            return head;
        }

        return node1;
    }

    public static Node josephusKill1(Node head, int m) {
        if (null == head || head.next == head || m < 1) {
            return head;
        }

        Node last = head;
        while (last.next != head) {
            last = last.next;
        }

        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }

        return head;
    }

    public static Node josephusKill2(Node head, int m) {
        if (null == head || head.next == head || m < 1) {
            return head;
        }
        Node cur = head.next;
        int tmp = 1; //list size;
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }

        tmp = getLive(tmp, m); //tmp = 存活的结点。
        while (--tmp != 0) {
            head = head.next;
        }

        head.next = head;
        return head;
    }

    private static int getLive(int i, int m) {
        if (1 == i) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (null != head) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        if (null == head || null == head.next) {
            return false;
        }

        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                if (head.value != stack.pop().value) {
                    return false;
                }
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (null == head || null == head.next) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        //查找中间结点。
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;//右半边翻转后的头结点。
        n2 = head;//左边的头结点。
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n3;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static Node listPartition(Node head, int pivot) {
        if (null == head) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; ++i) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; ++i) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];

    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }

    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }


    public static Node listPartion2(Node head, int pivot) {
        Node sH = null;//小的头；
        Node sT = null;//小的尾；
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;

        //所有结点分进三个链表；
        while (null != head) {
            next = head.next;
            if (head.value < pivot) {
                if (null == sH) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (null == eH) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (null == bH) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = head.next;
        }

        //连接三个链表；
        if (null != sT) {
            sT.next = eH;
            eT = (null == eT ? sT : eT);
        }
        if (null != eT) {
            eT.next = bH;
        }

        return (sH != null) ? sH : (eH != null ? eH : bH);
    }

    public static Node1 copyListWithRand1(Node1 head) {
        HashMap<Node1, Node1> map = new HashMap<Node1, Node1>();
        Node1 cur = head;
        while (cur != null) {
            map.put(cur, new Node1(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node1 copyListWithRand2(Node1 head) {
        if (null == head) {
            return null;
        }

        Node1 cur = head;
        Node1 next = null;
        //复制并连接每一个结点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node1(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node1 curCopy = null;
        //设置复制结点的rand指针
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = (cur.rand != null ? cur.rand.next : null);
            cur = next;
        }

        Node1 res = head.next;
        cur = head;

        //拆分
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.next = (next != null ? next.next : null);
            cur = next;
        }

        return res;
    }

    public static Node addList1(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (head1 != null) {
            s1.push(head1.value);
            head1 = head1.next;
        }

        while (head2 != null) {
            s2.push(head2.value);
            head2 = head2.next;
        }

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;

        Node node = null;
        Node pre = null;

        while (!s1.empty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }

        if (1 == ca) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }


    public static Node addLists2(Node head1, Node head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node c1 = head1;
        Node c2 = head2;
        Node node = null;
        Node pre = null;

        while (c1 != null || c2 != null) {
            n1 = (c1 != null ? c1.value : 0);
            n2 = (c2 != null ? c2.value : 0);
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
            c1 = (c1 != null ? c1.next : null);
            c2 = (c2 != null ? c2.next : null);
        }

        if (1 == ca) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }

        revereList(head1);
        revereList(head2);
        return node;
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node getLoopNode(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return null;
        }
        Node n1 = head.next; //n1 -> show
        Node n2 = head.next.next; //n2 -> fast

        while (n1 != n2) {
            if (null == n2.next || null == n2.next.next) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; //n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;
        cur2 = (cur1 == head1 ? head2 : head1);
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }

        while (cur1 == cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur1.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = (cur1 == head1 ? head2 : head1);
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        return null;
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (null == loop1 && null == loop2) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }


    public static Node reverseKNodes1(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<Node>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                pre = resign1(stack, pre, next);
                newHead = (newHead == head ? cur : newHead);
            }
            cur = next;
        }
        return newHead;
    }

    private static Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }

        cur.next = right;
        return cur;
    }

    public Node reverseKNode2(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;

        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = (pre == null ? head : pre.next);
                head = (pre == null ? cur : head);
                resign2(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public static void resign2(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (left != null) {
            left.next = end;
        }

        start.next = right;
    }

    public static void removeRep1(Node head) {
        if (null == head) {
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (null != cur) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }


    public static void removeRep2(Node head) {

        Node cur = head;
        Node pre = null;
        Node next = null;

        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }


    public Node removeValue1(Node head, int num) {
        Stack<Node> stack = new Stack<Node>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    public static Node removeValue2(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;

        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //将二叉树转换为链表的第一中方法。
    public static TreeNode convert1(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        TreeNode pre = head;
        pre.left = null;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }

        pre.right = null;
        return head;

    }

    //二叉树的中序遍历；
    public static void inOrderToQueue(TreeNode head, Queue<TreeNode> queue) {
        if (null == head) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }


    public static Node selectionSort(Node head) {
        Node tail = null; //排序部分尾部；
        Node cur = head; //位排序的部分头部；
        Node smallPre = null; //最小结点的前一个结点；
        Node small = null; //最小结点

        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = (small == cur ? cur.next : cur);
            if (null == tail) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;

    }

    private static Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;

        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }

    //一种怪异的节点删除方式
    public void removeNodeWired(Node node){
        if(null == node){
            return;
        }

        Node next = node.next;
        if(null == next){
            throw new RuntimeException("can't remove last node");
        }
        node.value = next.value;
        node.next = next.next;
    }

    //向有序环形链表插入节点
    public static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (null == head) {
            node.next = node;
            return node;
        }

        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }

    //合并两个有序的链表
    public static Node merge(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return head1 != null ? head1 : head2;
        }
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;

        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }

        pre.next = cur1 == null ? cur2 : cur1;
        return head;

    }


    //按照左右半区方式重新组合链表。
    public static void relocate(Node head) {
        if (null == head || null == head.next) {
            return;
        }

        Node mid = head;
        Node right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
    }

    private static void mergeLR(Node left, Node right) {
        Node next = null;
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }
}

