import java.util.Arrays;

public class MyCollectionImpl implements Collection{

    public MyCollectionImpl() {
        this.massConstruct = new String[5];
        size = 0;
    }
    public MyCollectionImpl(String[] mass) {
        this.massConstruct = mass;
        size = mass.length;
    }
    private int size;
    private String [] massConstruct;



    @Override
    public boolean add(int index, String value) throws Exception {
        if (index>size||index<0){
            throw new Exception("Sorry you cant use index " + index + " Size: " + size);
        }
        incrSizeMassFilling();
        addByIndex(index, value);
        return true;
    }

    @Override
    public boolean add(String value) {
        incrSizeMassFilling();
            massConstruct[size] = value;
            size++;
        System.out.println(Arrays.toString(massConstruct));
            return true;
    }
    @Override
    public boolean delete(int index) throws Exception {
        if (index>size||index<0){
            throw new Exception("Sorry you cant use index " + index + " Size: " + (size));
        }
        deleteElement(index);
        return true;
    }
    @Override
    public boolean delete(String value) throws Exception {
        deleteElement(value);
        return true;
    }
    @Override
    public String get(int index) throws Exception {
        if (index>(size-1)||index<0) throw new Exception("out of range collection Index " + index + " Size " + (size));
        return massConstruct[index];
    }

    @Override
    public boolean contain(String o) {
        return containInCollection(o);
    }
    @Override
    public boolean equals(Collection str) throws Exception {
        return equalsCollections(str);
    }
    @Override
    public int size() {
        return getSize();
    }

    @Override
    public boolean clear() {
        return clearCollection();
    }

    private void incrSizeMassFilling (){
        if(massConstruct.length<=size){
            String [] incrMass = new String[massConstruct.length+5];
            for (int i = 0; i < massConstruct.length; i++) {incrMass[i] = massConstruct[i];}
            massConstruct = incrMass;
            System.out.println("incrMass " + Arrays.toString(massConstruct));
        }
    }
    private void addByIndex(int index, String value){

        for (int i = size-1; i >= index ; i--) {
            massConstruct[i+1] = massConstruct[i];
        }
        massConstruct[index] = value;
        size++;
        System.out.println("value " + value);
        System.out.println("mass " + Arrays.toString(massConstruct));
    }

    private void deleteElement(int index) throws Exception {
        for (int i = index; i <= size-1 ; i++) {
            if(size <= 0) throw new Exception("Sorry you cant delete this " + size + " element");
            massConstruct[i] = massConstruct[i+1];
        }
        if (!(size<=0))size--;
        System.out.println(Arrays.toString(massConstruct));
    }
    private void deleteElement(String value) throws Exception {
        boolean existElement = false;
        for (int i = 0; i <size-1 ; i++) {
            if(massConstruct[i].equals(value)) {
                existElement = true;
                deleteElement(i);
                i--;
            }
        }
        if (!existElement) throw new Exception("Sorry you cant delete this " + value + " element");
        System.out.println("Delete element by val " + value);
        System.out.println("Delete element from mass Arr after delete " + Arrays.toString(massConstruct));
    }

    private boolean containInCollection(String value){
        for (int i = 0; i < size; i++) {
            if (massConstruct[i].equals(value)) return true;
        }
        return false;
    }
    private boolean equalsCollections(Collection collection) throws Exception {
        if(this == collection) return true;
        if(collection.size()==size){

            for (int i = 0; i < size; i++) {
                if(!massConstruct[i].equals(collection.get(i)))return false;
            }
            return true;
        }
        return false;
    }
    private int getSize(){
        return size;
    }

    private boolean clearCollection(){
        massConstruct = new String[5];
        size = 0;
        System.out.println(Arrays.toString(massConstruct));
        return true;
    }

}