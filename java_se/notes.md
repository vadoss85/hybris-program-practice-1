#Own notes

## Schema
![Schema](https://metanit.com/java/tutorial/pics/5.1.png)
## ArrayList
It's a resizable array. It means that on creating an array it has 10 slots by default. After pushing 11th element, it creates a new double sized array and copies all values to the new one. 10 -> 20 -> 40 slots.
It's faster to retrieval but slower to manipulate.

We can set initial number of slot in constructor.

## LinkedList
It's a doubly-linked (двусвязный) array. It's faster to manipulate but slower to retrieval

Both this list implements *List* interface so we can use it as type in methods params
```java
public void someMethod(List someList) {
    for(int i; i < someList.size(); i++) {
        System.out.println(someList.get(i))
    }
}
```

##HashSet
Set is used for storing an uniq values and prevents duplicates. It sorts values on adding.

##LinkedHashSet
Set is used for storing an uniq values and prevents duplicates. It saves order of added values.

##Collection methods
*.removeAll(Collection arr)* removes **all values** matched to provided values.

##HashMap
A dictionary contains pairs key:value. Saves order of elements was put.

##TreeMap
Same as HashMap but sorts data alphabetically by key. Entries with same keys will be replaced and the last one only wil be available.

##Deadlock
Case when thread A waits for end of thread B and thread B wait for thread A;

##Multithreading
1. Our class should extend *Thread* class and implement method *run()*;
2. To start a new thread we should run method *start()* of created object;
3. If another method *start()* called before previous call was done, it should be thrown a special exception *IllegalThreadStateException*;
4. We can use *Thread.sleep()* to "slow down" the thread;
5. We can change the default thread name *Thread-{index}* by calling
```java
Thread.currentThread().setName(String name)
```
in *run()* method of *Thread* class;
5. We can create class that implements interface *Runnable* implement method *run()* and use instance of this class as constructor argument for class *Thread*. Then we should call method *start()* of instance of *Thread* class;
6. At any given point of time, the processor can only give control(ability to execute code) to one thread. The processor is only capable of hand of handling over control to one thread at a time. Processor handling the control over to the thread to run some code and then takes away that control to another thread;
7. If we are sharing data between threads we are going to have all kinds of inconsistencies. One thread may be done reading the data, the other thread may still need to read that data;
8. Thread safe uses concept known as **autonomous city - all or nothing**. In multi thread programs lines of code can run part by part and on each part the control can be taken away to other thread;
9. Synchronized keyword - makes the part of code *atomic*(all or nothing);
10. We can use *synchronized* keyword as block of code
```java
synchronized(this) {
    ...
}
```
or in method definition
```java
public synchronized int methodName()
```
11. Covering a part of code with *synchronized* keyword is also called **lock**;
12. We can use method *.join()* on *Thread* object to wait until thread is complete;
13. Base Collections(ArrayList etc) are not thread because it will slow down other things;
14. In Java 1 was introduced *Vector* list structure with *synchronized* methods;
15. In Java 5 was introduced *concurrent* collections;
16. We should use collections from *concurrent* package to avoid multi threading object access problems';
17. Every single *Object* has methods *wait()* and *notify()*. These methods can be invoked only in *synchronized* block;
18. Method *wait()* passes control to other thread until method *notify()* will be called;
19. Method *notify()* notifies other threads that are "waiting";
20. It's recommended to **STAY AWAY** from *notify()* and *wait()* methods and use **concurrent utilities**;
21. BlockingQueue from *concurrent* package - data structure with *synchronized* methods for working with arrays of data;
22. ArrayBlockingQueue needs *capacity* - number of elements;
23. ArrayBlockingQueue uses methods *put()* and *take()* to add and remove elements from array;
24. Avoid of **over using** *synchronized* blocks because this will slow down n application;
25. Producer Consumer pattern can have *multiple* Producers and multiple Consumers;
26. ThreadPools is probably most useful way of working with threads
27. ThreadPool - container of threads that are managed. These threads are basiclly created by ExecutorService
28. ExecutorService = service that manages the thread pool';
29. ExecutorService's method *shutdown()* gracefully shut down's service. It's **very important to have!**;
30. *Executors.newFixedThreadPool(int nThreads)* spawns given number of threads


###Questions
1. How often is used objects *.equals()* and *.hashCode()* methods override?