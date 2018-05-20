/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.prsolution.winstrike.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import ru.prsolution.winstrike.model.PidDb;


@Entity(tableName = "pid")
public class PidEntity implements PidDb {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String publickId;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublickId() {
        return publickId;
    }

    public void setPublickId(String publickId) {
        this.publickId = publickId;
    }

    public PidEntity() {
    }

    @Ignore
    public PidEntity(PidEntity pid) {
        this.id = pid.getId();
        this.publickId = pid.getPublickId();
    }


}