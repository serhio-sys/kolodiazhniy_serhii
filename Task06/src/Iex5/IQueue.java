package Iex5;

import ex5.MultiThreadCommand;

public interface IQueue {
    public void put(MultiThreadCommand command);
    MultiThreadCommand take();
}
