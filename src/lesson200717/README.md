# Lesson 20.07.2017

- Semaphore, acquire()-release()
-- lock with timeout -> tryAcquire()
-- multiple conditions -> few semaphores

- CountDownLatch class

| feature / synchronization type      | volatile | synchronized | lock   | semaphore | atomic |
| ----------------------------------- | -------- | ------------ | ------ |---------- | ------ |
| solves race condition problem       |    -     |     yes      |  yes   |   *yes*   |   ?    |
| visibility                          |   yes    |     yes      |  yes   |   *yes*   |   ?    |
| can be interrupted                  |    -     |      -       |  yes   |   *yes*   |   ?    |
| lock with timeout                   |    -     |      -       |  yes   |   *yes*   |   ?    |
| lock/unlock in separate code blocks |    -     |      -       |  yes   |   *yes*   |   ?    |
| lock/unlock in different threads    |    -     |      -       |   -    |    yes    |   ?    |
| multiple conditions                 |    -     |      -       |  yes   |    *-*    |   -    |
| fair                                |    -     |      -       |  yes   |   *yes*   |        |

## books

- Doug Lea, Concurrent programming in Java (for this lesson - example 2.5.1.4)
- Грегори Эндрюс, Основы многопоточного, параллельного и распределенного программирования

## task

https://github.com/broadinstitute/picard - optimize code
