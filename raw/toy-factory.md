---
title: Toy Factory 
---


LintCode: https://www.lintcode.com/en/problem/toy-factory/

Problem
-------

Factory is a design pattern in common usage. Please implement a ToyFactory which can generate proper toy based on the given type.

```java
ToyFactory tf = ToyFactory();
Toy toy = tf.getToy('Dog');
toy.talk(); 
>> Wow

toy = tf.getToy('Cat');
toy.talk();
>> Meow
```

Solution
--------
