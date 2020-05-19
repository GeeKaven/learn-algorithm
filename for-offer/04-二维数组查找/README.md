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
1. 初始位置从右上角num开始比较, 
2. target < num 则去除最后一列
3. target > num 则去除第一行
重复上述操作直到相等为止，否则未找到

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