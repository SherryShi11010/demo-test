package com.leecode;

import java.util.Arrays;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class RepeatedNums {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            long length = (long)nums.length;
            long count = Arrays.stream(nums).distinct().count();
            boolean result = length < count;
            return  result;




        };
    }

    static class DefaultThreadFactory implements ThreadFactory{

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +poolNumber.getAndIncrement() +"-thread-";

        }

        public static void main(String[] args) {
            DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory();
            ThreadGroup testGroup = new ThreadGroup("测试");
            System.out.println(testGroup.getParent());
            System.out.println(defaultThreadFactory.group);
            AtomicInteger atomicInteger = new AtomicInteger(1);
        }


        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    }
}
