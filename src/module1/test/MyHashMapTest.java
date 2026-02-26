package module1.test;

import module1.MyHashMap;
import org.junit.jupiter.api.*;

class MyHashMapTest {

    private MyHashMap<Object, Object> map;

    @BeforeEach
    void setup() {
        map = new MyHashMap<>();
    }

    @Test
    void testGet() {
        map.put("spoon", 5);
        Assertions.assertEquals(5, map.get("spoon"));
        Assertions.assertNull(map.get("fork"));
    }

    @Test
    void testPut() {
        Assertions.assertEquals(5, map.put("spoon", 5));
        Assertions.assertEquals(5, map.get("spoon"));
        Assertions.assertNull(map.get("fork"));
    }

    @Test
    void testRemove() {
        map.put("spoon", 5);
        map.put("fork", 3);
        Assertions.assertEquals(5, map.remove("spoon"));
        Assertions.assertNull(map.get("spoon"));
    }
}
