public interface Collection {
    boolean add (int index, String value) throws Exception;
    boolean add (String value);
    boolean delete (int index) throws Exception;
    boolean delete (String value) throws Exception;
    String get(int index) throws Exception;
    boolean contain(String o);
    boolean equals (Collection str) throws Exception;
    boolean clear();
    int size();

}
