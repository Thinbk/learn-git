package btap;

public class BubbleSort {
    
static int array[] = new int[10];
    
    static void printTempArray(){ //In các kết quả trung gian
        for(int i = 0;i< array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        array[0] = 9;
        array[1] = 8;
        array[2] = 7;
        array[3] = 6;
        array[4] = 5;
        array[5] = 4;
        array[6] = 3;
        array[7] = 2;
        array[8] = 1;
        array[9] = 0;
        System.out.print("Dãy số ban đầu: ");
        printTempArray();
        //Nguyên tắc của thuật toán sắp xếp này là giá trị bé nhất cho lên trên!
        for(int i = 0; i< array.length; i++){
            for (int j = array.length - 1; j > 0; j--) {
               if(array[j] < array[j-1]){
                   int temp = array[j];
                   array[j] = array[j-1];
                   array[j-1] = temp;
               }
            }
            System.out.print("Kết quả trung gian thứ "+ (i +1) +": ");
            printTempArray();
        }
    }
}
