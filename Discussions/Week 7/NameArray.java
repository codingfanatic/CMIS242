class NameArray<String>{
    private String[] array;
    private int size;

    public NameArray(){
        array = (String[]) new Object[5];
        size = 0;
    }

    public String getName(int i){
        return array[i];
    }

    public void add(String name){
        array[size++] = name;
    }
}

class TestNames{
    public static void main(String[] args){
        NameArray<String> array = new NameArray<String>();
    }
}