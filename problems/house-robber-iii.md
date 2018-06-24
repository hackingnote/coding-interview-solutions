# House Robber III

## Problem

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.

## Example

```
  3
 / \
2   3
 \   \
  3   1
```

Maximum amount of money the thief can `rob = 3 + 3 + 1 = 7`.

```
    3
   / \
  4   5
 / \   \
1   3   1
```

Maximum amount of money the thief can `rob = 4 + 5 = 9`.

## Code(Java)

```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *   public int val;
 *   public TreeNode left, right;
 *   public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        int[] dp = search(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] search(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) {
            return dp;
        }
        int[] left = search(root.left);
        int[] right = search(root.right);

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + root.val;

        return dp;
    }
}
```
