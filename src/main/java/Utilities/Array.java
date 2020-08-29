package Utilities;

import java.util.Random;

/**
 * Created by Administrator on 2020/8/29.
 */
public class Array {
    //Random Partition
    static int RandomInRange(int min, int max){
        Random random = new Random(25);
        //rand.nextInt(100);中的100是随机数的上限,产生的随机数为0-100的整数,不包括100。
        int iRandom = random.nextInt(max - min) + min;
        return iRandom;
    }

    static void Swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num1 = temp;
    }

    static int Partition(int[] data,int length, int start, int end){
        if(data==null || length <= 0 || start < 0|| end >= length){
            System.out.println("Invalid Parameters");
            return -1;

        }
        int index = RandomInRange(start,end);
        Swap(data[index],data[end]);
        int small = start -1;
        for (index = start; index < end ;++index){
            if(data[index] < data[end]){
                ++small;
                if(small !=  index){
                    Swap(data[index] , data[small]);
                }
            }
        }
        ++small;
        Swap(data[small],data[end]);
        return small;
    }
}
