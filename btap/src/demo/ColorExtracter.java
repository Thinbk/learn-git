
package demo;

import java.util.ArrayList;
public class ColorExtracter {
    
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
        excelData.add(3,"Ngày 23/07/1995 011");
    }
    
    void extractFirstColor(ArrayList<String> excelData){
        

        ArrayList<String> cpyExcelData = new ArrayList<String>(excelData);
        
        //đây là mảng đếm xem trong ngày màu (chỉ số) xuất hiện ntn!
        int colorcodes [] = new int[14];
        for (int i = 0; i < colorcodes.length; i++) {
            colorcodes[i] = 0;
        }

        for (int i = 0; i < cpyExcelData.size(); i++) {
            if(!cpyExcelData.get(i).isEmpty()){
                String strColorsDate = cpyExcelData.get(i);
                strColorsDate = strColorsDate.substring(16,strColorsDate.length());
                //Loại bỏ ngày tháng
                String strColorIndexs[] = strColorsDate.split(" ");
                int intColorIndexs[] = new int[strColorIndexs.length];
                for (int j = 0; j < strColorIndexs.length; j++) {
                    intColorIndexs[j] = Integer.valueOf(strColorIndexs[j]); //Chuyển String sang int
                    colorcodes[intColorIndexs[j]]++;
                }
            }
        }
        
        //Tìm xem mã màu (chỉ số) nào được xuất ra nhiều nhất

        for (int i = 0; i < colorcodes.length; i++) {           
            int sumAmount = colorcodes[i];
            String strIndexGroup = "" + i;
            extractColors(cpyExcelData, strIndexGroup, sumAmount, 1, i);
        }

        
    }
    
    
    void extractInputColor(ArrayList<String> excelData,int firstindex, int secondindex){
        

        ArrayList<String> cpyExcelData = new ArrayList<String>(excelData);
        
        //đây là mảng đếm xem trong ngày màu (chỉ số) xuất hiện ntn!
        int colorcodes [] = new int[14];
        for (int i = 0; i < colorcodes.length; i++) {
            colorcodes[i] = 0;
        }
        
        int nremovedrow = solveInputColors(cpyExcelData, firstindex, secondindex);
                  
        if((!cpyExcelData.isEmpty())){
            for (int i = 0; i < cpyExcelData.size(); i++) {
                if(!cpyExcelData.get(i).isEmpty()){
                    String strColorsDate = cpyExcelData.get(i);
                    strColorsDate = strColorsDate.substring(16,strColorsDate.length());
                    //Loại bỏ ngày tháng
                    String strColorIndexs[] = strColorsDate.split(" ");
                    int intColorIndexs[] = new int[strColorIndexs.length];
                    for (int j = 0; j < strColorIndexs.length; j++) {
                        intColorIndexs[j] = Integer.valueOf(strColorIndexs[j]); //Chuyển String sang int
                        colorcodes[intColorIndexs[j]]++;
                    }
                }
            }
        
            //Tìm xem mã màu (chỉ số) nào được xuất ra nhiều nhất

            for (int i = 0; i < colorcodes.length; i++) {
                if((i!=firstindex)||(i!=secondindex)){
                    int sumAmount = nremovedrow + colorcodes[i];
                    String strIndexGroup = firstindex+" "+secondindex + " " + i;
                    extractColors(cpyExcelData, strIndexGroup, sumAmount, 3, i,firstindex,secondindex);
                }
            }     
        }
        else{
           System.out.println("Nhóm mã màu: "+firstindex+" "+secondindex);
           System.out.println("Số ngày bán được: "+nremovedrow);
           System.out.println();
       }                    
    }
    
    
    
    void extractColors(ArrayList<String> excelData, String strIndexGroup, int sumAmount, int nelemnt, int previousindexcolor){
        
        ArrayList<String> cpyexcelData = new ArrayList<String>(excelData);
        
        //đây là mảng đếm xem trong ngày màu (chỉ số) xuất hiện ntn!
        int colorcodes [] = new int[14];
        for (int i = 0; i < colorcodes.length; i++) {
            colorcodes[i] = 0;
        }
        
        removeArrayList(cpyexcelData, previousindexcolor);
        
        if((!cpyexcelData.isEmpty())){
            
            for (int i = 0; i < cpyexcelData.size(); i++) {
                String strColorsDate = cpyexcelData.get(i);
                strColorsDate = strColorsDate.substring(16,strColorsDate.length());
                //Loại bỏ ngày tháng
                String strColorIndexs[] = strColorsDate.split(" ");
                int intColorIndexs[] = new int[strColorIndexs.length];
                for (int j = 0; j < strColorIndexs.length; j++) {
                    intColorIndexs[j] = Integer.valueOf(strColorIndexs[j]); //Chuyển String sang int
                    colorcodes[intColorIndexs[j]]++;
                }
            }
            
            
            
            
            
        
            //Tìm xem mã màu (chỉ số) nào được xuất ra nhiều nhất

            for (int i = previousindexcolor+1; i < colorcodes.length; i++) {
                int cpysumAmount = sumAmount + colorcodes[i];
                String strCpyIndexGroup = strIndexGroup;
                strCpyIndexGroup += " " + i;
                nelemnt++;
                if(nelemnt<5){
                    extractColors(cpyexcelData, strCpyIndexGroup, cpysumAmount, nelemnt, i);
                }
                else{
                    System.out.println("Nhóm mã màu: "+strCpyIndexGroup);
                    System.out.println("Số ngày bán được: "+cpysumAmount);
                    System.out.println();
                }
                
            }
        }
        else{
           System.out.println("Nhóm mã màu: "+strIndexGroup);
           System.out.println("Số ngày bán được: "+sumAmount);
           System.out.println();
       }
    }
    
    //Chưa đúng
    void extractColors(ArrayList<String> excelData, String strIndexGroup, int sumAmount, int nelemnt, int previousindexcolor,int firstindex, int secondindex){
        
        ArrayList<String> cpyexcelData = new ArrayList<String>(excelData);
        
        //đây là mảng đếm xem trong ngày màu (chỉ số) xuất hiện ntn!
        int colorcodes [] = new int[14];
        for (int i = 0; i < colorcodes.length; i++) {
            colorcodes[i] = 0;
        }
        
        removeArrayList(cpyexcelData, previousindexcolor);
        
        if((!cpyexcelData.isEmpty())){
            
            for (int i = 0; i < cpyexcelData.size(); i++) {
                String strColorsDate = cpyexcelData.get(i);
                strColorsDate = strColorsDate.substring(16,strColorsDate.length());
                //Loại bỏ ngày tháng
                String strColorIndexs[] = strColorsDate.split(" ");
                int intColorIndexs[] = new int[strColorIndexs.length];
                for (int j = 0; j < strColorIndexs.length; j++) {
                    intColorIndexs[j] = Integer.valueOf(strColorIndexs[j]); //Chuyển String sang int
                    colorcodes[intColorIndexs[j]]++;
                }
            }         
            //Tìm xem mã màu (chỉ số) nào được xuất ra nhiều nhất

            for (int i = previousindexcolor+1; i < colorcodes.length; i++) {
                if((i!=firstindex)||(i!=secondindex)){
                    int cpysumAmount = sumAmount + colorcodes[i];
                    String strCpyIndexGroup = strIndexGroup;
                    strCpyIndexGroup += " " + i;
                    nelemnt++;
                    if(nelemnt<5){
                        extractColors(cpyexcelData, strCpyIndexGroup, cpysumAmount, nelemnt, i,firstindex,secondindex);
                    }
                    else{
                        System.out.println("Nhóm mã màu: "+strCpyIndexGroup);
                        System.out.println("Số ngày bán được: "+cpysumAmount);
                        System.out.println();
                    }
                    
                }
                
            }
        }
        else{
           System.out.println("Nhóm mã màu: "+strIndexGroup);
           System.out.println("Số ngày bán được: "+sumAmount);
           System.out.println();
       }
    }
    
    
    void removeArrayList(ArrayList<String> excelData,int previousIndex){
        
        String strpreviousIndex = "";
        strpreviousIndex += previousIndex;
        for (int i = strpreviousIndex.length(); i < 3; i++) {
            strpreviousIndex = "0" + strpreviousIndex;
        }
        
        for (int i = excelData.size()-1; i >= 0; i--) {
            if(excelData.get(i).contains(strpreviousIndex)){
                excelData.remove(i);
            }
        }
    }
    
    int solveInputColors(ArrayList<String> excelData,int firstindex, int secondindex){
        
        int nRemovedRow = 0;
        
        String strFirstIndex = "";
        strFirstIndex += firstindex;
        for (int i = strFirstIndex.length(); i < 3; i++) {
            strFirstIndex = "0" + strFirstIndex;
        }
        
        String strSecondIndex = "";
        strSecondIndex += secondindex;
        for (int i = strSecondIndex.length(); i < 3; i++) {
            strSecondIndex = "0" + strSecondIndex;
        }
        
        for (int i = excelData.size()-1; i >= 0; i--) {
            if(excelData.get(i).contains(strFirstIndex)||excelData.get(i).contains(strSecondIndex)){
                excelData.remove(i);
                nRemovedRow ++;
            }
        }
        
        return nRemovedRow;
    }
    public static void main(String[] args) {
        ColorExtracter colorextracter = new ColorExtracter();
        colorextracter.addData();
        
//        colorextracter.extractFirstColor(colorextracter.excelData);
        colorextracter.extractInputColor(colorextracter.excelData, 1, 12);
    }
}
