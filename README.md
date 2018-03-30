## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |  1000000           | 0.007748        |
| Using ReentrantLock     |  1000000           | 0.096573        |
| Syncronized method      |                    |                 |
| AtomicLong for total    |                    |                 |

## 1. Using unsynchronized counter object

answer the questions (1.1 - 1.3)

- 1.1 The result should be zero but my result, its got zero only sometime and always have different result.
- 1.2 0.0015249, 0.016571, 0.017230, 0.014691 ; **Average:** *0.015935249999999998*
- 1.3 Because On AddTask and SubTask can be start on different timing so the result are not not zero. Maybe because 
    both are run on different Thread, when one of those thread finish its end the result witch 
    another one will stop at that point.

## 2. Implications for Multi-threaded Applications

How might this affect real applications?  

- this behavior can make the value not be an actual because its show the result of thread that run on same time
    with another thread but get the value during one of thread finished.

## 3. Counter with ReentrantLock

answer questions 3.1 - 3.4

- 3.1 its always 0. **RECORD:** 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.

## 4. Counter with synchronized method

answer question 4

## 5. Counter with AtomicLong

answer question 5

## 6. Analysis of Results

answer question 6

## 7. Using Many Threads (optional)

