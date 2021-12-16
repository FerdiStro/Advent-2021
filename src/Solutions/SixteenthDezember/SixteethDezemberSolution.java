package Solutions.SixteenthDezember;

import Solutions.Scanner.Scann;

import java.util.ArrayList;
import java.util.List;

public class SixteethDezemberSolution extends Scann {
    List<Pack> allPackagesList = new ArrayList<>();
    Integer partOne = 0 ;

    private void caluclate(){
        List<String> hexaList = this.scannFile("rsc/inputSixteethDezember.txt");
        List<String> binarList = this.hexInBinar(hexaList);
        for(String binarListString : binarList) {
            Pack pack = calculatePackages(binarListString);
            allPackagesList.add(pack);
        }
        System.out.println("PartOne : " + partOne);
    }

    private  Pack calculatePackages(String binary){
        Pack pack = new Pack();
        if(binary != null){
        String[] binar = binary.split("");
        Integer labelVersion = this.binarInDezimal(binar[0] + binar[1] + binar[2]);
        Integer packID = this.binarInDezimal(binar[3]+binar[4]+binar[5]);
        String length = binar[6];
        pack.setLabelVersion(labelVersion);
        partOne = partOne + labelVersion;
        pack.setPackID(packID);
        pack.setLength(length);
        if(length.equals("0")){
            try {
            Integer lengthPackage = this.binarInDezimal(binar[7]+binar[8]+binar[9]+binar[10]+binar[11]+binar[12]+binar[13]+binar[14]+binar[15]+binar[16]+binar[17]+binar[18]+binar[19]+binar[20]+binar[21]);
            pack.setLengthPackage(lengthPackage);
            String binaryString = "";
            for(int  j = 22  ; j  != binary.length() ; j++){
                binaryString = binaryString + binar[j];
            }
            Pack pack1 = calculatePackages(binaryString);
            pack.addPackages(pack1);
            }catch (Exception e){}
        }else{
            Integer lengthPackage = this.binarInDezimal(binar[7]+binar[8]+binar[9]+binar[10]+binar[11]+binar[12]+binar[13]+binar[14]+binar[15]+binar[16]+binar[17]);
            pack.setLengthPackage(lengthPackage);
            String binaryString = "" ;
            for(int  j = 18  ; j  != binary.length() ; j++){
                binaryString = binaryString + binar[j];
            }
            Pack pack1 = calculatePackages(binaryString);
            pack.addPackages(pack1);
        }

        }else {
            pack =  null;
        }
        return  pack;

    }






    public void Solution(){
        Day16 day16 = new Day16();
        day16.Soulution();
    }





}
class Pack{
    private Integer labelVersion;
    private Integer packID;
    private String length;
    private Integer lengthPackage;
    private List<Pack> Packages = new ArrayList<>();

    public void addPackages(Pack pack){
        this.Packages.add(pack);

    }







    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Integer getLabelVersion() {
        return labelVersion;
    }

    public void setLabelVersion(Integer labelVersion) {
        this.labelVersion = labelVersion;
    }

    public Integer getPackID() {
        return packID;
    }

    public void setPackID(Integer packID) {
        this.packID = packID;
    }

    public Integer getLengthPackage() {
        return lengthPackage;
    }

    public void setLengthPackage(Integer lengthPackage) {
        this.lengthPackage = lengthPackage;
    }
}
