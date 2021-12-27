/*
 * Copyright © 2021 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package events;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;

public class ProgramStatusEventDetails {

    private final String runID;
    private final String programName;
    private final String namespace;
    private final String status;
    private final long eventTime;
    @Nullable
    private final Map<String, String> userArgs;
    @Nullable
    private final Map<String, String> systemArgs;
    private final String error;
    @Nullable
    private final Collection<PluginMetrics> pluginMetrics;

    /**
     *
     * @param runID
     * @param programName
     * @param namespace
     * @param status
     * @param eventTime
     * @param userArgs
     * @param systemArgs
     * @param error
     * @param pluginMetrics
     */
    private ProgramStatusEventDetails(String runID, String programName, String namespace, String status, long eventTime,
                                      @Nullable Map<String, String> userArgs, @Nullable Map<String, String> systemArgs,
                                      @Nullable String error,
                                      @Nullable Collection<PluginMetrics> pluginMetrics) {
        this.runID = runID;
        this.programName = programName;
        this.namespace = namespace;
        this.status = status;
        this.eventTime = eventTime;
        this.userArgs = userArgs;
        this.systemArgs = systemArgs;
        this.error = error;
        this.pluginMetrics = pluginMetrics;
    }

    /**
     *
     * @param runID
     * @param programName
     * @param namespace
     * @param status
     * @param eventTime
     * @return
     */
    public static Builder getBuilder(String runID, String programName, String namespace, String status, long eventTime) {
        return new Builder(runID, programName, namespace, status, eventTime);
    }

    static class Builder {

        private String runID;
        private String programName;
        private String namespace;
        private String status;
        private long eventTime;
        private Map<String, String> userArgs;
        private Map<String, String> systemArgs;
        private String error;
        private Collection<PluginMetrics> pluginMetrics;

        Builder(String runID, String programName, String namespace, String status, long eventTime) {
            this.runID = runID;
            this.programName = programName;
            this.namespace = namespace;
            this.status = status;
            this.eventTime = eventTime;
        }

        public Builder withUserArgs(Map<String, String> userArgs) {
            this.userArgs = userArgs;
            return this;
        }

        public Builder withSystemArgs(Map<String, String> systemArgs) {
            this.systemArgs = systemArgs;
            return this;
        }

        public Builder withError(String error) {
            this.error = error;
            return this;
        }

        public Builder withPluginMetrics(Collection<PluginMetrics> pluginMetrics) {
            this.pluginMetrics = pluginMetrics;
            return this;
        }

        public ProgramStatusEventDetails build() {
            return new ProgramStatusEventDetails(runID, programName, namespace, status, eventTime, userArgs, systemArgs,
                    error, pluginMetrics);
        }

    }

}