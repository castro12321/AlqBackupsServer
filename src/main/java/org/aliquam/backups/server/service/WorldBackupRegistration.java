/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aliquam.backups.server.service;

import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.aliquam.backups.server.model.WorldBackup;
import org.aliquam.backups.server.model.WorldBackupRequest;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class WorldBackupRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<WorldBackup> worldBackupEventSrc;

    public void register(WorldBackupRequest worldBackupRequest) throws Exception {
        log.info("Registering " + worldBackupRequest.getWorldName());
        
        // TODO: perform actual backup (or request such)
        WorldBackup backup = new WorldBackup();
        backup.setWorldName(worldBackupRequest.getWorldName());
        backup.setCreationDate(new Date());
        backup.setArchivePath("backups/" + backup.getCreationDate());
        
        em.persist(backup);
        worldBackupEventSrc.fire(backup);
    }
}
