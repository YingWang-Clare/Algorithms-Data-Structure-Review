/*
    fibo:

    1 1 2 3 5 8 13 ..

    public int fibo(int n) {
        // base case:
        if (n == 1 || n == 0) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

              fn -----------------1
            /    \
           fn-1  fn-2 ----------- 2
          /   \
         fn-2 fn-3 ---------------4
        /
       fn-3 ----------------------8
      /
    ...
    /
   1 ---------------------------- 2^n

    recursion tree height: n, so space O(n)
    time: 1+2+4+8+... = 2^n = O(2^n)
    for binary tree, the number of all leaf nodes in the binary tree is larger than the rest nodes in the binary tree.
    Thus, we only care about the nodes in the leaf level.
 */