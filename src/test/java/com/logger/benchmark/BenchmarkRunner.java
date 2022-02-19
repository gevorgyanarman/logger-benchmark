package com.logger.benchmark;


import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BenchmarkRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(BenchmarkRunner.class);

    @Benchmark
    @Fork(value = 2)
    @Warmup(iterations = 1, time = 10000, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(value = Mode.Throughput)
    public void logTestDebugWithArguments(ExecutionPlan plan) {
        LOGGER.debug("Test - {}, - {} - {}",
            plan.arg1,
            plan.arg2,
            plan.arg3
        );
    }

    @Benchmark
    @Fork(value = 2)
    @Warmup(iterations = 1, time = 10000, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(value = Mode.Throughput)
    public void logTestInfoWithArguments(ExecutionPlan plan) {
        LOGGER.info("Test - {}, - {} - {}",
            plan.arg1,
            plan.arg2,
            plan.arg3
        );
    }

    @Benchmark
    @Fork(value = 2)
    @Warmup(iterations = 1, time = 10000, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(value = Mode.Throughput)
    public void logTestDebugWithBuilder(ExecutionPlan plan) {
        LOGGER.debug(
            new StringBuilder("Test - ")
                .append(plan.arg1)
                .append(plan.arg2)
                .append(plan.arg3)
                .toString()
        );
    }

    @Benchmark
    @Fork(value = 2)
    @Warmup(iterations = 1, time = 10000, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(value = Mode.Throughput)
    public void logTestInfoWithBuilder(ExecutionPlan plan) {
        LOGGER.info(
            new StringBuilder("Test - ")
                .append(plan.arg1)
                .append(plan.arg2)
                .append(plan.arg3)
                .toString()
        );
    }

    @Benchmark
    @Fork(value = 2)
    @Warmup(iterations = 1, time = 10000, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(value = Mode.Throughput)
    public void logTestDebugWithConcat(ExecutionPlan plan) {
        LOGGER.debug(
            "Test - " +
                plan.arg1 +
                plan.arg2 +
                plan.arg3
        );
    }

    @Benchmark
    @Fork(value = 2)
    @Warmup(iterations = 1, time = 10000, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(value = Mode.Throughput)
    public void logTestInfoWithConcat(ExecutionPlan plan) {
        LOGGER.info(
            "Test - " +
                plan.arg1 +
                plan.arg2 +
                plan.arg3
        );
    }

    @State(Scope.Benchmark)
    public static class ExecutionPlan {

        private String arg1;
        private String arg2;
        private String arg3;

        private static String uuid() {
            return UUID.randomUUID().toString() + UUID.randomUUID().toString();
        }

        @Setup(Level.Iteration)
        public void setUp() {
            arg1 = uuid();
            arg2 = uuid();
            arg3 = uuid();
        }
    }
}
