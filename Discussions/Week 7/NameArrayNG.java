class NamesArrayNG{
    private Object[] array;
    private int size;
    
    public NamesArray(){
        array = new Object[5];
        size = 0;
    }

    public Object getName(int i){
        return array[i];
    }

    public void add(Object o){
        array[size++] = o;
    }
}

class TestNamesNG{
    public static void main(String[] args){
        NameArray<String> array = new NameArray<String>();
        array.add("Asuma");
        System.out.println(array.getName(0));
        array.add("Boruto");
        System.out.println(array.getName(1));
        array.add("Ikki");
        System.out.println(array.getName(2));
        array.add("Jiraiya");
        System.out.println(array.getName(3));
        array.add("A");
        System.out.println(array.getName(4));
    }
}