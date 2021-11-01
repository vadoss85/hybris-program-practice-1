# hybris-program-practice-1
Hybris Academy practice work. Part 1

###Collections log
```bash
---------------------------
--- COLLECTIONS EXAMPLE ---
---------------------------

[Lists example]
---------------
-- Array List --
arr size => 3
first element => string 1
second element => inserted by index string;
-- Linked List --
arr size => 0
arr size => 5
[4]
-- List traversing (Loops) --
-- For.. loop --
Cat
Bird
Dog
Lion
-- For..in loop --
Cat
Bird
Dog
Lion
-- List of objects --
Vehicle{model='Honda', make='accord', price=12000, isFourWheels=true}
Vehicle{model='Toyota', make='carola', price=9000, isFourWheels=false}
Vehicle{model='Jeep', make='wrangler', price=15000, isFourWheels=true}
-- Using `List` type --
Vehicle{model='Honda', make='accord', price=12000, isFourWheels=true}
Vehicle{model='Toyota', make='carola', price=9000, isFourWheels=false}
Vehicle{model='Jeep', make='wrangler', price=15000, isFourWheels=true}

[Sets example]
---------------
-- HashSet --
A
B
Y
Z
-- LinkedHashSet --
A
Z
B
Y
-- HashSet of objects --
Vehicle{model='Honda', make='accord', price=12000, isFourWheels=true}
Vehicle{model='Jeep', make='wrangler', price=15000, isFourWheels=true}
Vehicle{model='Toyota', make='carola', price=9000, isFourWheels=false}
Vehicle{model='Jeep', make='wrangler', price=15000, isFourWheels=true}
-- HashSet of objects with override hashCode() and equals() methods --
jeep3 hashCode() =>1585389004
jeep4 hashCode() =>1585389004
true
Vehicle{model='Jeep', make='wrangler', price=15000, isFourWheels=true}

[Collection example]
---------------
-- ArrayList addAll() --
[1, 2, 3, 4, 5]
-- ArrayList removeAll() --
array [a, b, b, b, c]
array to remove [b, c]
result[a]
-- ArrayList clear() --
array [a, b, b, b, c]
result[]
-- ArrayList contains() --
array [a, b, c]
isExists a true
isExists d false
-- ArrayList isEmpty() --
isEmpty false
-- ArrayList retainAll() --
array [a, b, b, b, c]
array to retain [b, c]
result[b, b, b, c]
-- ArrayList sort() --
[2, 4, 10, 13, 155]
-- ArrayList sort() objects --
vehicles array [Vehicle{model='Jeep', make='wrangler', price=15000, isFourWheels=true}, Vehicle{model='Honda', make='accord', price=12000, isFourWheels=true}, Vehicle{model='Toyota', make='carola', price=9000, isFourWheels=false}]
vehicles array sorted by price [Vehicle{model='Toyota', make='carola', price=9000, isFourWheels=false}, Vehicle{model='Honda', make='accord', price=12000, isFourWheels=true}, Vehicle{model='Jeep', make='wrangler', price=15000, isFourWheels=true}]

[HashMap example]
---------------
-- put() --
map {third=three, first=one, second=two}
-- loop() --
third three
first one
second two

[TreeMap example]
---------------
-- loop() --
a str2
b str3
c str1

```

###Introducing Threading
```bash
---------------------------------
--- CONCURRENCY INTRO EXAMPLE ---
---------------------------------
First line
Fourth line
0
0
1
2
1
2
3
4
3
4
5
6
7
8
9
5
6
7
8
9
```
###Starting Threads and the Runnable Interface
```bash
---------------------------------
--- CONCURRENCY INTRO EXAMPLE ---
---------------------------------
Starting FirstTread
Starting SecondTread
0 FirstTread
0 SecondThread
1 SecondThread
1 FirstTread
2 SecondThread
2 FirstTread
3 SecondThread
3 FirstTread
4 SecondThread
4 FirstTread
5 FirstTread
5 SecondThread
6 FirstTread
6 SecondThread
7 SecondThread
7 FirstTread
8 FirstTread
8 SecondThread
9 SecondThread
9 FirstTread
```

###Thread Safety Using Synchronization
```bash
-------------------------------------------
--- CONCURRENCY SYNCHRONIZATION EXAMPLE ---
-------------------------------------------
FirstThread got value 1
SecondThread got value 2
SecondThread got value 4
FirstThread got value 3
SecondThread got value 5
FirstThread got value 6
SecondThread got value 7
FirstThread got value 8
SecondThread got value 9
FirstThread got value 10
SecondThread got value 11
FirstThread got value 12
SecondThread got value 13
FirstThread got value 14
SecondThread got value 15
FirstThread got value 16
SecondThread got value 17
FirstThread got value 18
SecondThread got value 19
FirstThread got value 20
SecondThread got value 21
FirstThread got value 22
SecondThread got value 23
FirstThread got value 24
SecondThread got value 25
FirstThread got value 26
SecondThread got value 27
FirstThread got value 28
SecondThread got value 29
FirstThread got value 30
SecondThread got value 31
FirstThread got value 32
SecondThread got value 33
FirstThread got value 34
SecondThread got value 35
FirstThread got value 36
SecondThread got value 37
FirstThread got value 38
SecondThread got value 39
FirstThread got value 40
```
###Thread Safety with Collections
```bash
--------------------------------------------
--- CONCURRENCY SAFE COLLECTIONS EXAMPLE ---
--------------------------------------------
Added: product_0
Added: product_1
Added: product_2
Added: product_3
Added: product_4
Added: product_5
Added: product_6
Sold: product_0
Sold: product_1
Sold: product_2
Sold: product_3
Sold: product_4
Sold: product_5
Sold: product_6
Added: product_7
Added: product_8
Added: product_9
```
###Producer Consumer Pattern Using wait() and notify()
```bash
---------------------------------------------
--- CONCURRENCY PRODUCER CONSUMER EXAMPLE ---
---------------------------------------------
new Question: 0
new Question: 1
ANSWERED QUESTION: 0
ANSWERED QUESTION: 1
No questions to answer. Waiting for Producer get questions
new Question: 2
new Question: 3
new Question: 4
new Question: 5
new Question: 6
Questions have piled up. Wait for answers
ANSWERED QUESTION: 2
ANSWERED QUESTION: 3
ANSWERED QUESTION: 4

Process finished with exit code 130
```
###Producer Consumer Pattern Using a BlockingQueue
```bash
----------------------------------------------------------------------
--- CONCURRENCY PRODUCER CONSUMER USING ARRAYBLOCKINGQUEUE EXAMPLE ---
----------------------------------------------------------------------
Got new Question: 1
Got new Question: 2
Got new Question: 3
Got new Question: 4
Got new Question: 5
Got new Question: 6
Got new Question: 7
Answered Question: 0
Answered Question: 1
Got new Question: 8
Answered Question: 2
Got new Question: 9
Answered Question: 3
Got new Question: 10
Answered Question: 4
Got new Question: 11
Answered Question: 5
Got new Question: 12

Process finished with exit code 130
```
###Thread Pools and the Executor Framework
```bash
----------------------------------------------------------------------
--- CONCURRENCY THREADPOOL AND EXECUTOR FRAMEWORK EXAMPLE ---
----------------------------------------------------------------------
pool-1-thread-1 [RECEIVED] Message = 2
pool-1-thread-2 [RECEIVED] Message = 3
submitted all tasks...
pool-1-thread-1 (DONE) Processing message = 2
pool-1-thread-2 (DONE) Processing message = 3
pool-1-thread-1 [RECEIVED] Message = 4
pool-1-thread-2 [RECEIVED] Message = 5
pool-1-thread-1 (DONE) Processing message = 4
pool-1-thread-2 (DONE) Processing message = 5
```

### Date And Time Java 8 API log
```bash
----------------------------------
--- DATETIME CREATION  EXAMPLE ---
----------------------------------
2021-11-01
20:40:48.324101300
2021-11-01T20:40:48.324101300
2021-10-31
12:12
2021-10-31T12:12
Mon Nov 01 20:40:48 EET 2021
Wed Jan 01 20:40:48 EET 2020
------------------------------
--- DATETIME USING EXAMPLE ---
------------------------------
2030-01-10
2030-03-15
10:30
12:50
2030-03-15T12:50
2030-03-20T02:50
Mon Mar 01 20:40:48 EET 2021
2010-04-01
--------------------------------
--- DATETIME PERIODS EXAMPLE ---
--------------------------------
Start:2017-01-01
Start:2017-01-16
Start:2017-01-31
Start:2017-02-15
Start:2017-03-02
Start:2017-03-17
Start:2017-04-01
Start:2017-04-16
2017-01-16
2021-11-16T20:40:48.356015400
P1Y1M
-----------------------------------
--- DATETIME FORMATTING EXAMPLE ---
-----------------------------------
2010-04-15
2010-04-15T11:22:33
11:22:33
4/15/10
4/15/10
Apr 15, 2010, 11:22:33
08:40
11:22
11:22
--------------------------------
--- DATETIME PARSING EXAMPLE ---
--------------------------------
2010-02-15
11:22
02 15 2010
05 05 2010
10 10 2010
```

### Date And Time Java 8 API log
```bash
--------------------------------------------------
--- FUNCTIONAL INTERFACES AND LAMBDAS  EXAMPLE ---
--------------------------------------------------
Custom object walking
Custom object walking
Custom object walking2
--------------------------------------------------
--- FUNCTIONAL INTERFACES AND LAMBDAS  EXAMPLE ---
--------------------------------------------------
Custom object walking
Custom object walking
Custom object walking2
10
0
gnirts emos
720
--------------------------------------------------
--- BUILT-IN FUNCTIONAL EXAMPLE ---
--------------------------------------------------
price = 22300 color = Red
price between 18k and 22k
Car{make='Mitsubishi', model='Lancer', color='White', price=20000}
cars with blue color
Car{make='Honda', model='Civic', color='Blue', price=17700}
Car{make='Toyota', model='Camry', color='Blue', price=24000}
-----------------------
--- STREAMS EXAMPLE ---
-----------------------
123456789
6789
10

Africa
Bitcoin
Computer Application
Dry Cleaner
Education
Health Insurance
Keyboard
Powerade
Samantha
White Board

Samantha, Health Insurance, 
3

APPL 145 422
AMZN 690 849
```