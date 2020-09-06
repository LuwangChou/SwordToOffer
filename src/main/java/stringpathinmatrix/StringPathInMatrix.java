package stringpathinmatrix;
// 面试题12：矩阵中的路径
// 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
// 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
// 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
// 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
// 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
// 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
// A B T G
// C F C S
// J D E H
/**
 * Created by Administrator on 2020/8/29.
 */
public class StringPathInMatrix {

    public StringPathInMatrix(){

    }

    /**
     * 回溯法
     * @param matrix
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param str
     * @param pathLength
     * @param visited
     * @return
     */
    boolean hasPathCore(char[][] matrix , int rows, int cols, int row, int col, char[] str,int pathLength,boolean[][] visited){
        if (matrix == null|| rows < 1 || cols < 1 || str == null ){
            return false;
        }
        if (str.length == pathLength){
            return true;
        }

        boolean isHasPath = false;
        if ( row >= 0 && row < rows && col >= 0 && col < cols ){
            boolean isCharCorrect = false;
//            System.out.println("matrix"+matrix[row][col]);
//            System.out.println("pathLength"+str[pathLength]);
            if(pathLength < str.length && pathLength >= 0){
                isCharCorrect = (matrix[row][col] == str[pathLength]);
            }
            if ( isCharCorrect && !visited[row][col]) {
                ++pathLength;
                visited[row][col] = true;

                isHasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                        || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                        || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                        || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited);
                if (!isHasPath) {
                    --pathLength;
                    visited[row][col] = false;
                }
            }

        }
        return isHasPath;
    }

    /**
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    boolean hasPath(char[][] matrix, int rows, int cols, char[] str){
        if (matrix == null|| rows < 1 || cols < 1){
            return false;
        }

        boolean [][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                visited[row][col] = false;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }


    void test(String testName, char[][] matrix,int rows, int cols,char[] str,boolean expected){
        System.out.println(testName+" begins.");
        if (hasPath(matrix,rows,cols,str) == expected){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }

    //ABTG
    //CFCS
    //JDEH

    //BFCE
    void test1(){
        char []array1 = "ABTG".toCharArray();
        char []array2 = "CFCS".toCharArray();
        char []array3 = "JDEH".toCharArray();
        char[][] matrix = {array1,array2,array3};
        char[] str = "BFCE".toCharArray();
        test("Test1",matrix,3,4,str,true);
    }

    //ABCE
    //SFCS
    //ADEE

    //SEE
    void test2(){
        char []array1 = "ABCE".toCharArray();
        char []array2 = "SFCS".toCharArray();
        char []array3 = "ADEE".toCharArray();
        char[][] matrix = {array1,array2,array3};
        char[] str = "SEE".toCharArray();
        test("Test2",matrix,3,4,str,true);
    }
    //ABTG
    //CFCS
    //JDEH

    //ABFB
    void test3(){
        char []array1 = "ABTG".toCharArray();
        char []array2 = "CFCS".toCharArray();
        char []array3 = "JDEH".toCharArray();
        char[][] matrix = {array1,array2,array3};
        char[] str = "ABFB".toCharArray();
        test("Test3",matrix,3,4,str,false);
    }

    //ABCEHJIG
    //SFCSLOPQ
    //ADEEMNOE
    //ADIDEJFM
    //VCEIFGGS

    //SLHECCEIDEJFGGFIE
    void test4(){
        char []array1 = "ABCEHJIG".toCharArray();
        char []array2 = "SFCSLOPQ".toCharArray();
        char []array3 = "ADEEMNOE".toCharArray();
        char []array4 = "ADIDEJFM".toCharArray();
        char []array5 = "VCEIFGGS".toCharArray();
        char[][] matrix = {array1,array2,array3,array4,array5};
        char[] str = "SLHECCEIDEJFGGFIE".toCharArray();
        test("Test4",matrix,5,8,str,true);
    }


    //ABCEHJIG
    //SFCSLOPQ
    //ADEEMNOE
    //ADIDEJFM
    //VCEIFGGS

    //SGGFIECVAASABCEHJIGQEM
    void test5(){
        char []array1 = "ABCEHJIG".toCharArray();
        char []array2 = "SFCSLOPQ".toCharArray();
        char []array3 = "ADEEMNOE".toCharArray();
        char []array4 = "ADIDEJFM".toCharArray();
        char []array5 = "VCEIFGGS".toCharArray();
        char[][] matrix = {array1,array2,array3,array4,array5};
        char[] str = "SGGFIECVAASABCEHJIGQEM".toCharArray();
        test("Test5",matrix,5,8,str,true);
    }

    //ABCEHJIG
    //SFCSLOPQ
    //ADEEMNOE
    //ADIDEJFM
    //VCEIFGGS

    //SGGFIECVAASABCEEJIGOEM  倒数第二位错误
    void test6(){
        char []array1 = "ABCEHJIG".toCharArray();
        char []array2 = "SFCSLOPQ".toCharArray();
        char []array3 = "ADEEMNOE".toCharArray();
        char []array4 = "ADIDEJFM".toCharArray();
        char []array5 = "VCEIFGGS".toCharArray();
        char[][] matrix = {array1,array2,array3,array4,array5};
        char[] str = "SGGFIECVAASABCEEJIGOEM".toCharArray();
        test("Test6",matrix,5,8,str,false);
    }

    //ABCEHJIG
    //SFCSLOPQ
    //ADEEMNOE
    //ADIDEJFM
    //VCEIFGGS

    //SGGFIECVAASABCEHJIGQEMS   多了一位字母
    void test7(){
        char []array1 = "ABCEHJIG".toCharArray();
        char []array2 = "SFCSLOPQ".toCharArray();
        char []array3 = "ADEEMNOE".toCharArray();
        char []array4 = "ADIDEJFM".toCharArray();
        char []array5 = "VCEIFGGS".toCharArray();
        char[][] matrix = {array1,array2,array3,array4,array5};
        char[] str = "SGGFIECVAASABCEHJIGQEMS".toCharArray();
        test("Test8",matrix,5,8,str,false);
    }



    //AAAA
    //AAAA
    //AAAA

    //AAAAAAAAAAAA  全为A 重复字母
    void test8(){
        char []array1 = "AAAA".toCharArray();
        char []array2 = "AAAA".toCharArray();
        char []array3 = "AAAA".toCharArray();
        char[][] matrix = {array1,array2,array3};
        char[] str = "AAAAAAAAAAAA".toCharArray();
        test("Test8",matrix,3,4,str,true);
    }


    //AAAA
    //AAAA
    //AAAA

    //AAAAAAAAAAAAA  多了一位字母
    void test9(){
        char []array1 = "AAAA".toCharArray();
        char []array2 = "AAAA".toCharArray();
        char []array3 = "AAAA".toCharArray();
        char[][] matrix = {array1,array2,array3};
        char[] str = "AAAAAAAAAAAA".toCharArray();
        test("Test9",matrix,3,4,str,true);
    }

    //A

    //A 单个字母
    void test10(){
        char[][] matrix = {{'A'}};
        char[] str = {'A'};
        test("Test10",matrix,1,1,str,true);
    }

    //A

    //B 单个字母，错误字母
    void test11(){
        char[][] matrix = {{'A'}};
        char[] str = {'B'};
        test("Test11",matrix,1,1,str,false);
    }


    //字母为空
    void test12(){
        test("Test12",null,0,0,null,false);
    }

    public void executeTest(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
    }


}
