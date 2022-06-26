
class TV {
    private int size;
    TV(){}
    TV(int size){
        this.size=size;
    }
    protected int getSize() {
        return size;
    }
}

class ColorTv extends TV {
    private int color;
    private int size;

    ColorTv(int size, int color) {
        this.size = size;
        this.color = color;
    }
    ColorTv(){}

    void printProperty() {
        System.out.println(size + "인치 " + color + "컬러");
    }

    public static void main(String[] args) {
        //ColorTv a=new TV();
        //a.printProperty();
    }

}

