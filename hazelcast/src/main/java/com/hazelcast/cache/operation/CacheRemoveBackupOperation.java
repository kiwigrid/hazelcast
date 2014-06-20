/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.cache.operation;

import com.hazelcast.cache.CacheDataSerializerHook;
import com.hazelcast.nio.serialization.Data;
import com.hazelcast.spi.BackupOperation;

/**
 * @author mdogan 05/02/14
 */
public class CacheRemoveBackupOperation extends AbstractCacheOperation implements BackupOperation {

    public CacheRemoveBackupOperation() {
    }

    public CacheRemoveBackupOperation(String name, Data key) {
        super(name, key);
    }

    @Override
    public void run() throws Exception {
        if (cache != null) {
            response = cache.remove(key, null);
        } else {
            response = Boolean.FALSE;
        }
    }

    @Override
    public void afterRun() throws Exception {
    }

    @Override
    public int getId() {
        return CacheDataSerializerHook.REMOVE_BACKUP;
    }

}