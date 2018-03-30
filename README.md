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
| Syncronized method      |  1000000           | 0.086584        |
| AtomicLong for total    |  1000000           | 0.036065        |

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

- 3.1 its always 0. **RECORD:** *0.002793, 0.002060, 0.002484, 0.002205* **Average:** *0.0023855*
- 3.2 Lock lock the thread to run once at a time.
- 3.3 its for run the thread one at a time. Use it to run many thread.
- 3.4 for unlock the Lock to work on another thread when the thread finished.

## 4. Counter with synchronized method
answer question 4

- 4.1 The result is always zero. **Average Time:** *0.001040*
- 4.2 First problem are work thread on same time which finish on one of thread finish but this work separately
 until both thread finished.
- 4.3 "synchronized" is the word of coordinate. Is for work on program correctly on using many thread.  

## 5. Counter with AtomicLong

answer question 5

- 5.1 because AtomicCounter use AtomicLong and AtomicLong is make no reason for make it correct. But my own thinks,
i think because of working something on system so make the value correctly.
- 5.2 Use for speed up the progress. 
 

## 6. Analysis of Results

answer question 6

- 6.1 On the result the *Counter* is the fastest by result are not correctly, So the fastest is *AtomicCounter* and Slowest 
is *ReentrantLock*.
- 6.2 *Syncronized method*

## 7. Using Many Threads (optional)

