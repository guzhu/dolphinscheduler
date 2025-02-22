/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.server.master.metrics;

import java.util.function.Supplier;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;


public final class TaskMetrics {
    private TaskMetrics() {
        throw new UnsupportedOperationException("Utility class");
    }

    private static final Counter TASK_SUBMIT_COUNTER =
            Counter.builder("dolphinscheduler_task_submit_count")
                    .description("Task submit total count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_FINISH_COUNTER =
            Counter.builder("dolphinscheduler_task_finish_count")
                    .description("Task finish total count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_SUCCESS_COUNTER =
            Counter.builder("dolphinscheduler_task_success_count")
                    .description("Task success total count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_FAILURE_COUNTER =
            Counter.builder("dolphinscheduler_task_failure_count")
                    .description("Task failure total count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_TIMEOUT_COUNTER =
            Counter.builder("dolphinscheduler_task_timeout_count")
                    .description("Task timeout total count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_RETRY_COUNTER =
            Counter.builder("dolphinscheduler_task_retry_count")
                    .description("Task retry total count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_STOP_COUNTER =
            Counter.builder("dolphinscheduler_task_stop_count")
                    .description("Task stop total count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_FAILOVER_COUNTER =
            Counter.builder("dolphinscheduler_task_failover_count")
                    .description("Task failover total count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_DISPATCH_COUNTER =
            Counter.builder("dolphinscheduler_task_dispatch_count")
                    .description("Task dispatch count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_DISPATCHER_FAILED =
            Counter.builder("dolphinscheduler_task_dispatch_failed_count")
                    .description("Task dispatch failed count")
                    .register(Metrics.globalRegistry);

    private static final Counter TASK_DISPATCH_ERROR =
            Counter.builder("dolphinscheduler_task_dispatch_error_count")
                    .description("Task dispatch error")
                    .register(Metrics.globalRegistry);

    public static void incTaskSubmit() {
        TASK_SUBMIT_COUNTER.increment();
    }

    public synchronized static void registerTaskRunning(Supplier<Number> consumer) {
        Gauge.builder("dolphinscheduler_task_running_gauge", consumer)
                .description("Task running count")
                .register(Metrics.globalRegistry);
    }

    public static void incTaskFinish() {
        TASK_FINISH_COUNTER.increment();
    }

    public static void incTaskSuccess() {
        TASK_SUCCESS_COUNTER.increment();
    }

    public static void incTaskFailure() {
        TASK_FAILURE_COUNTER.increment();
    }

    public static void incTaskTimeout() {
        TASK_TIMEOUT_COUNTER.increment();
    }

    public static void incTaskRetry() {
        TASK_RETRY_COUNTER.increment();
    }

    public static void incTaskStop() {
        TASK_STOP_COUNTER.increment();
    }

    public static void incTaskFailover() {
        TASK_FAILOVER_COUNTER.increment();
    }

    public static void incTaskDispatchFailed(int failedCount) {
        TASK_DISPATCHER_FAILED.increment(failedCount);
    }

    public static void incTaskDispatchError() {
        TASK_DISPATCH_ERROR.increment();
    }

    public static void incTaskDispatch() {
        TASK_DISPATCH_COUNTER.increment();
    }

}
