package btap;

public class VDID {
    
    public static void main(String[] args) {
        int arrInt[];
        arrInt = new int[4];
        arrInt[0] = 9;
        arrInt[1] = 17;
        arrInt[2] = 13;
        arrInt[3] = 14;
 
        String arrString[] = {"Vu Van A", "Nguyen Van B", "Nguyen Van C", "Nguyen dang C"};
 
        System.out.println("Mảng số nguyên: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(arrInt[i] + " ");
        }
        System.out.println("\nMảng các chuỗi: ");
 
        for (int i = 0; i < 4; i++) {
            System.out.println(arrString[i] + " ");
        }
        System.out.println("");
    }
}
    