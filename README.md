# Logger Facade benchmark
## _Java Microbenchmark Harness_

The aim of the project is to do a performance test on the logger facade using 2 approaches

- Log a message according to the specified format and arguments.
- Log a concatenated message without arguments  

The message is logged at 2 different log levels

- DEBUG
- INFO

##### Current log level is INFO

## Benchmark parameters

- Fork - 2 (total 10 iterations)
- Warmup 10 seconds
- Benchmark mode - throughput

## How to run

The logger-benchmark is a gradle project integrated with me.champeau.jmh plugin

```sh
cd logger-benchmark
./gradlew jmh
```

The application executes logger performance tests at trace, debug and info levels and it may produce billions of lines of logs. The preferable way to run the performance test and examine the result is:

```sh
cd logger-benchmark
./gradlew jmh > result.txt
tail -40 result.txt
```

## Dependencies

| group:name | version |
| ------ | ------ |
| org.slf4j:slf4j-api | 1.7.25 |
| org.slf4j:slf4j-log4j12 | 1.7.25 |

## Plugins

| plugin | version |
| ------ | ------ |
| java | - |
| me.champeau.jmh | 0.6.6 |

## Benchmark result (operations per second)
 
| Benchmark | Mode | Cnt | Score | Error | Units |
| ------ | ------ | ------| ------| ------| ------|
| BenchmarkRunner.logTestDebugWithArguments | thrpt | 10| 382521367.161 +-| 64697557.246| ops/s
| BenchmarkRunner.logTestDebugWithBuilder | thrpt | 10|  =31351089.875 +-| ==747895.543| ops/s
| BenchmarkRunner.logTestDebugWithConcat | thrpt | 10|  =32889289.434 +-| ==1439574.494| ops/s
| BenchmarkRunner.logTestInfoWithConcat | thrpt | 10|  ====48691.513 +-| =====3493.645| ops/s
| BenchmarkRunner.logTestInfoWithBuilder | thrpt | 10|  ====45869.987 +-| =====2180.246| ops/s
| BenchmarkRunner.logTestInfoWithConcat | thrpt | 10|  ====45686.131 +-| =====8321.283| ops/s
