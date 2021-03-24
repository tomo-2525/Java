# Generic Type

## 宣言方法
```java
class Store<T>{
    private int count;
    private T[] arr = (T[])new Object[10];
}

public T get(final int i) { 
    if (i < arr.length) return arr[i]; return null;
}

public boolean set(final T obj) { 
    if (count < arr.length) {
        arr[count++] = obj; return true;
    }else{
        return false;
    }

// this Store takes only Strings
final Store<String> store = new Store<String>();


store.set(“a string”);
store.set(new Integer(4)); // a compile time error 
String str = store.get(1); // cast not needed
```


## Generic method
```java
public class Box<T> {
private T t; // T stands for "Type" 

public void add(T t) {
this.t = t; 
}

public T get() { 
    return t;
    }

public <U> void inspect(U u) {
System.out.println("T: " + t.getClass().getName());
System.out.println("U: " + u.getClass().getName());
}

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.add(new Integer(10));
        integerBox.inspect("some text");
    }
}
```

## Bounded Type Parameter


# Inner Class
