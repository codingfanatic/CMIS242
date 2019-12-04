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
        array.add(4.12);
        
        String first = (String) array.getName(0);
        String second = (String) array.getName(1);
        String third = (String) array.getName(2);
        String fourth = (String) array.getName(3);
        String fifth = (String) array.getName(4);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(fifth);
    }
}