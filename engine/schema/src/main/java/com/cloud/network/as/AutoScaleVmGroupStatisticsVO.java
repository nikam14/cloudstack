// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.network.as;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cloud.server.ResourceTag;
import org.apache.cloudstack.api.InternalIdentity;

@Entity
@Table(name = "autoscale_vmgroup_statistics")
public class AutoScaleVmGroupStatisticsVO implements InternalIdentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "vmgroup_id")
    private long vmGroupId;

    @Column(name = "counter_id")
    private long counterId;

    @Column(name = "resource_id")
    private long resourceId;

    @Column(name = "resource_type")
    @Enumerated(value = EnumType.STRING)
    private ResourceTag.ResourceObjectType resourceType;

    @Column(name = "raw_value")
    private Double rawValue = null;

    @Column(name = "created")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created = null;

    public AutoScaleVmGroupStatisticsVO() {
    }

    public AutoScaleVmGroupStatisticsVO(long vmGroupId, long counterId, long resourceId, ResourceTag.ResourceObjectType resourceType, Double rawValue, Date created) {
        this.vmGroupId = vmGroupId;
        this.counterId = counterId;
        this.resourceId = resourceId;
        this.resourceType = resourceType;
        this.rawValue = rawValue;
        this.created = created;
    }

    @Override
    public long getId() {
        return id;
    }

    public long getVmGroupId() {
        return vmGroupId;
    }

    public long getCounterId() {
        return counterId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public ResourceTag.ResourceObjectType getResourceType() {
        return resourceType;
    }

    public Double getRawValue() {
        return rawValue;
    }

    public Date getCreated() {
        return created;
    }
}
