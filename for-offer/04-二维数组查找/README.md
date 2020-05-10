# 04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


示例:

现有矩阵 matrix 如下：
```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```
给定 target = 5，返回 true。

给定 target = 20，返回 false。

 

限制：
```
0 <= n <= 1000

0 <= m <= 1000
```

# 解法1
先来按照正常人思维找普遍规律，若二维数组中选定一个数num，  
如果num < target，则target在num的右方，或者下方，但右下方重叠  
如果num > target，则target在num的左方，或者上方，但左上方重叠  
既然有重叠，则选择条件就有两个，那么思路就变成了从哪个点左为开始比较，则结果只有一种可能？  
从边开始，从右上，左下顶点作为开始则结果就一定在左方，或者上方

例如将右上设置为起始点num，num就是这一行最大值，这一列最小值  
如果target < num，则targe在num所在列的左边，不可能在num所在的列，因为这一列num已经最小了，删除对应的列
如果target > num，则targe在num所在行的下方，不可能在num所在的行，因为这一行num已经最大了，删除对应的行
继续从剩余矩阵右上顶点开始，找到target为止

``` Java
public boolean findNumberIn2DArray(int[][] matrix, int target) {
    boolean res = false;
    if (matrix != null && matrix.length > 0 && matrix[0] != null) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      if (rows > 0 && cols > 0) {
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
          int num = matrix[row][col];
          if (num > target) {
            col = col - 1;
          } else if (num < target) {
            row = row + 1;
          } else {
            res = true;
            break;
          }
        }
      }
    }
    return res;
  }
```