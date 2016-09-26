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
package org.aliquam.backups.server.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.aliquam.backups.server.model.WorldBackup;

@ApplicationScoped
public class WorldBackupRepository {

    @Inject
    private EntityManager em;

    public WorldBackup findById(Long id) {
        return em.find(WorldBackup.class, id);
    }

    public WorldBackup findByArchivePath(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<WorldBackup> criteria = cb.createQuery(WorldBackup.class);
        Root<WorldBackup> worldBackup = criteria.from(WorldBackup.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(worldBackup).where(cb.equal(worldBackup.get(WorldBackup_.name), email));
        criteria.select(worldBackup).where(cb.equal(worldBackup.get("archivePath"), email));
        return em.createQuery(criteria).getSingleResult();
    }
    
    public List<WorldBackup> findAllOrderedByCreationDate() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<WorldBackup> criteria = cb.createQuery(WorldBackup.class);
        Root<WorldBackup> worldBackup = criteria.from(WorldBackup.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(worldBackup).orderBy(cb.asc(worldBackup.get(WorldBackup_.name)));
        criteria.select(worldBackup).orderBy(cb.asc(worldBackup.get("creationDate")));
        return em.createQuery(criteria).getResultList();
    }
}
