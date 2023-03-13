package ex5;

import Iex4.IConsoleCommand;
import Iex5.IQueue;

import java.util.Vector;


public class CommandQueue implements IQueue {
    private Vector<MultiThreadCommand> tasks;
    private boolean waiting;
    private boolean shutdown;

    public void setShutdown(){
        shutdown=true;
    }

    public CommandQueue() {
        this.tasks = new Vector<>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    @Override
    public void put(MultiThreadCommand command) {
        tasks.add(command);
        if (waiting){
            synchronized (this){
                notifyAll();
            }
        }
    }

    @Override
    public MultiThreadCommand take() {
        if (tasks.isEmpty()){
            synchronized (this){
                waiting = true;
                try {
                    wait();
                }catch (InterruptedException ie){
                    waiting = false;
                }
            }
        }
        return tasks.remove(0);
    }

    private class Worker implements Runnable {
        /** Извлекает из очереди
         * готовые к выполнению
         * задачи; шаблон
         * Worker Thread */
        public void run() {
            while (!shutdown) {
                MultiThreadCommand r = take();
                try {
                    r.execute();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

