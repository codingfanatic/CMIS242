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
        array.add(new String("Asuma"));
        String first = array.getName(0);
        System.out.println(first);

        array.add(new String("Boruto"));
        String second = array.getName(1);
        System.out.println(second);

        array.add(new String("Ikki"));
        String third = array.getName(2);
        System.out.println(third);

        array.add(new String("Jiraiya"));
        String fourth = array.getName(3);
        System.out.println(fourth);

        array.add(Double.valueOf(4.12));
        String fifth = array.getName(4);
        System.out.println(fifth);
    }
}