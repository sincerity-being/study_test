# 算法的本质
**如果要让我一句话总结，我想说算法的本质就是「穷举」。**
这些题目类似脑筋急转弯，都是通过观察，发现规律，然后找到最优解法，不过这类算法问题较少，不必特别纠结。
再比如，密码学算法、机器学习算法，它们的本质确实不是穷举，而是数学原理的编程实现，所以这类算法的本质是数学.

**为了区分，不妨称算法工程师研究的算法为「数学算法」，称刷题面试的算法为「计算机算法」，我写的内容主要聚焦的是「计算机算法」**

只要学会用计算机思维解决问题就够了
**但是，你千万不要觉得穷举这个事儿很简单，穷举有两个关键难点：无遗漏、无冗余。**

**1、如何穷举？** 即无遗漏地穷举所有可能解。

**2、如何聪明地穷举？** 即避免所有冗余的计算，消耗尽可能少的资源求出答案。

**什么算法的难点在「如何穷举」呢？一般是递归类问题，最典型的就是动态规划系列问题**
先写出暴力穷举解法（状态转移方程），加个备忘录就成自顶向下的递归解法了，再改一改就成自底向上的递推迭代解法了.
因为想不出状态转移方程，第一步的暴力解法都写不出来。

**什么算法的难点在「如何聪明地穷举」呢？一些耳熟能详的非递归算法技巧，都可以归在这一类**

# 数组/单链表系列算法
**数组常用的技巧有很大一部分还是双指针相关的技巧，说白了是教你如何聪明地进行穷举。**

# 二叉树系列算法
**什么叫通过遍历一遍二叉树得出答案？**

就比如说计算二叉树最大深度这个问题让你实现 maxDepth 这个函数
```java
class Solution {

    // 记录最大深度
    int res = 0;
    int depth = 0;

    // 主函数
    int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    void traverse(TreeNode root) {
        if (root == null) {
            // 到达叶子节点
            res = Math.max(res, depth);
            return;
        }
        // 前序遍历位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
}

```

**那什么叫通过分解问题计算答案？**

```java
// 定义：输入根节点，返回这棵二叉树的最大深度
int maxDepth(TreeNode root) {
	if (root == null) {
		return 0;
	}
	// 递归计算左右子树的最大深度
	int leftMax = maxDepth(root.left);
	int rightMax = maxDepth(root.right);
	// 整棵树的最大深度
	int res = Math.max(leftMax, rightMax) + 1;

	return res;
}

```
不信你看 动态规划核心框架 中凑零钱问题的暴力穷举解法：
```java
// 定义：输入金额 amount，返回凑出 amount 的最少硬币个数
int coinChange(int[] coins, int amount) {
    // base case
    if (amount == 0) return 0;
    if (amount < 0) return -1;

    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
        // 递归计算凑出 amount - coin 的最少硬币个数
        int subProblem = coinChange(coins, amount - coin);
        if (subProblem == -1) continue;
        // 凑出 amount 的最少硬币个数
        res = Math.min(res, subProblem + 1);
    }

    return res == Integer.MAX_VALUE ? -1 : res;
}

```


如果你感受到最大深度这个问题两种解法的区别，那就趁热打铁，我问你，二叉树的前序遍历怎么写？
```java
List<Integer> res = new LinkedList<>();

// 返回前序遍历结果
List<Integer> preorder(TreeNode root) {
    traverse(root);
    return res;
}

// 二叉树遍历函数
void traverse(TreeNode root) {
    if (root == null) {
        return;
    }
    // 前序遍历位置
    res.add(root.val);
    traverse(root.left);
    traverse(root.right);
}

```
其实完全可以重写前序遍历代码，用分解问题的形式写出来，避免外部变量和辅助函数：
```java
// 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果
List<Integer> preorder(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) {
        return res;
    }
    // 前序遍历的结果，root.val 在第一个
    res.add(root.val);
    // 后面接着左子树的前序遍历结果
    res.addAll(preorder(root.left));
    // 最后接着右子树的前序遍历结果
    res.addAll(preorder(root.right));
    return res;
}

```

当然，动态规划系列问题有「最优子结构」和「重叠子问题」两个特性，而且大多是让你求最值的。
很多算法虽然不属于动态规划，但也符合分解问题的思维模式。

比如 分治算法详解 中说到的运算表达式优先级问题，其核心依然是大问题分解成子问题，
只不过没有重叠子问题，不能用备忘录去优化效率罢了。

**更进一步，图论相关的算法也是二叉树算法的延续。**

上述这些算法的本质都是穷举二（多）叉树，有机会的话通过剪枝或者备忘录的方式减少冗余计算，提高效率，就这么点事儿。
