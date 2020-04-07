package pl.romanek.webprojekt.sumThree;



public class sumLogic3 {
    private int x1; //tutaj musza być identyczne nazwy jak w pliku .jsp ("name=x1")
    private int x2;
    private int x3;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }
            
    public int sumowanie3(){
        
        return x1+x2+x3;
    }


}