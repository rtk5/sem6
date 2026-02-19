

class Sample{
    public static String name = "";
    public static void setName(String name){
        Sample.name = name;
    }
    public static String getName(){
        return Sample.name;
    }
}

public class staticmethodattr{
    public static void main(String[] args) {
        Sample.setName("John");
        System.out.println(Sample.getName());

        Sample obj = new Sample();
        obj.setName("Doe");
        System.out.println(obj.getName());
    }
}