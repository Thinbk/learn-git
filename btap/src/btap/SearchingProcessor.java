package btap;

import java.util.ArrayList;

public class SearchingProcessor {

    ArrayList<String> excelData = new ArrayList<String>();
    
    void addData(){
        excelData.add(0,"Ngày 12/07/1995 001 008 009 012");
        excelData.add(1,"Ngày 13/07/1995 002 009 013");
        excelData.add(2,"Ngày 14/07/1995 003 012 013");
        excelData.add(3,"Ngày 15/07/1995 004");
        excelData.add(0,"Ngày 16/07/1995 005 008 009 012");
        excelData.add(1,"Ngày 17/07/1995 006 009 012 013");
        excelData.add(2,"Ngày 18/07/1995 007 012 013");
        excelData.add(3,"Ngày 19/07/1995 008");
        excelData.add(0,"Ngày 20/07/1995 009 012");
        excelData.add(1,"Ngày 21/07/1995 010 012 013");
        excelData.add(2,"Ngày 22/07/1995 011 012 013");
        excelData.add(3,"Ngày 23/07/1995 012");
    }
    
    boolean searchColorCodeIndex(int findingindex){
        boolean check = false;
        String strfindingIndex = "";
        strfindingIndex += findingindex;
        for (int i = strfindingIndex.length(); i < 3; i++) {
            strfindingIndex = "0" + strfindingIndex;
        }
        
        for (int i = 0; i < excelData.size(); i++) {
            if(excelData.get(i).contains(strfindingIndex)){
                check = true;
                System.out.println("Đã tìm thấy chỉ số mã màu:"+findingindex);
                System.out.println("Ở dòng thứ: "+ i +" là: " + excelData.get(i));
                System.out.println("");
            }
        }
        return check;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SearchingProcessor sProcessor = new SearchingProcessor();
        sProcessor.addData();
        int findingindex = 8;
        boolean check = sProcessor.searchColorCodeIndex(findingindex);
        System.out.println("Kết luận");
        if (check == true) {
            System.out.println("Chỉ số mã màu có tồn tại trong file Excel");
        } 
        else {
            System.out.println("Chỉ số mã màu không tồn tại trong file Excel");
        }
    }
}
