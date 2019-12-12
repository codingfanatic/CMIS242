class NameArrayNG{
    private Object[] array;
    private int size;
    
    public NameArrayNG(){
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
        NameArrayNG array = new NameArrayNG();
        array.add(new String("Asuma"));
        array.add(new String("Boruto"));
        array.add(new String("Ikki"));
        array.add(new String("Jiraiya"));
        array.add(Double.valueOf(4.12));

        String first = (String) array.getName(0);
        System.out.println(first);
        String second = (String) array.getName(1);
        System.out.println(second);
        String third = (String) array.getName(2);
        System.out.println(third);
        String fourth = (String) array.getName(3);
        System.out.println(fourth);
        String fifth = (String) array.getName(4);
        System.out.println(fifth);
    }
}