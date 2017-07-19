# Lesson 18.07.2017

- BoundedBuffer

- await(), signal() methods of Condition

- RTFM :)


| feature / synchronization type      | volatile | synchronized | lock   | semaphore | atomic |
| ----------------------------------- | -------- | ------------ | ------ |---------- | ------ |
| solves race condition problem       |    -     |     yes      |  yes   |     ?     |   ?    |
| visibility                          |   yes    |     yes      |  yes   |     ?     |   ?    |
| can be interrupted                  |    -     |      -       |  yes   |     ?     |   ?    |
| lock with timeout                   |    -     |      -       |  yes   |     ?     |   ?    |
| lock/unlock in separate code blocks |    -     |      -       |  yes   |     ?     |   ?    |
| lock/unlock in different threads    |    -     |      -       |   -    |    yes    |   ?    |
| multiple conditions                 |    -     |      -       |  yes   |     -     |   -    |
| fair                                |    -     |      -       |  yes   |           |        |


## home task

- используя tryLock() (палочки - locks), переписать задачу с философами, использовать lock with timeout
- переписать BlockingQueue для задач на lock и condition
- повар/официант с BoundedBuffer
