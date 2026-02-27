package module1;

public class Main {

    public static void main(String[] args) {
        MyHashMap<String, String> hm = new MyHashMap<>();

        hm.put("spoon", "this is a spoon");
        System.out.println(hm.get("spoon"));

        hm.put("fork", "this is a fork");
        System.out.println(hm.get("fork"));

        hm.remove("fork");
        System.out.println(hm.remove("fork"));
    }
}
