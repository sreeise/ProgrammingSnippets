use std::collections::VecDeque;

// Stack: Last In First Out (LIFO)
#[derive(Debug, PartialEq, Eq)]
pub struct Stack<T> {
    data: VecDeque<T>,
}

impl<T> Stack<T> {
    pub fn new() -> Stack<T> {
        Stack {
            data: VecDeque::new(),
        }
    }

    pub fn pop(&mut self) {
        self.data.pop_back().expect("Cannot pop. Stack is empty.");
    }

    pub fn push(&mut self, item: T) {
        self.data.push_back(item);
    }

    pub fn peek(&mut self) -> &T {
        self.data.back().expect("Cannot peek. Stack is empty.")
    }

    pub fn is_empty(&self) -> bool {
        self.data.is_empty()
    }
}

// Queue: First In First Out (FIFO)
#[derive(Debug, PartialEq, Eq)]
pub struct Queue<T> {
    data: VecDeque<T>,
}

impl<T> Queue<T> {
    pub fn new() -> Queue<T> {
        Queue {
            data: VecDeque::new(),
        }
    }

    pub fn remove(&mut self) {
        self.data.pop_front().expect("No data in Queue");
    }

    pub fn add(&mut self, item: T) {
        self.data.push_back(item);
    }

    pub fn peek(&mut self) -> &T {
        self.data.back().expect("Cannot peek. Queue is empty.")
    }

    pub fn is_empty(&self) -> bool {
        self.data.is_empty()
    }
}

#[test]
fn stack_methods() {
    let mut stack = Stack::new();
    stack.push(3);
    stack.push(4);
    assert_eq!(stack.peek(), &4);
    stack.pop();
    assert_eq!(stack.peek(), &3);
    stack.push(6);
    assert_eq!(stack.peek(), &6);
    stack.pop();
    stack.pop();
    assert_eq!(stack.is_empty(), true);
}

#[test]
fn stack_partial_eq() {
    let mut stack = Stack::new();
    stack.push(3);
    stack.push(8);

    let mut stack2 =  Stack::new();
    stack2.push(3);
    stack2.push(8);

    assert_eq!(stack, stack2);

    let mut stack3 = Stack::new();
    stack3.push(4);
    stack3.push(8);

    assert_ne!(stack, stack3);
    assert_ne!(stack2, stack3);
}

#[test]
fn queue_methods() {
    let mut queue = Queue::new();
    queue.add(3);
    queue.add(4);
    assert_eq!(queue.peek(), &4);
    queue.remove();
    assert_eq!(queue.peek(), &4);
    queue.add(6);
    assert_eq!(queue.peek(), &6);
    queue.remove();
    assert_eq!(queue.peek(), &6);
    queue.remove();
    assert_eq!(queue.is_empty(), true);
}

#[test]
fn queue_partial_eq() {
    let mut queue = Queue::new();
    queue.add(3);
    queue.add(8);

    let mut queue2 = Queue::new();
    queue2.add(3);
    queue2.add(8);

    assert_eq!(queue, queue2);

    let mut queue3 = Queue::new();
    queue3.add(4);
    queue3.add(8);

    assert_ne!(queue, queue3);
    assert_ne!(queue2, queue3);
}
