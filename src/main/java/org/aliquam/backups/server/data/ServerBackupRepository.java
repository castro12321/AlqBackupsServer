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

import org.aliquam.backups.server.model.ServerBackup;

@ApplicationScoped
public class ServerBackupRepository {

    @Inject
    private EntityManager em;

    public ServerBackup findById(Long id) {
        return em.find(ServerBackup.class, id);
    }

    public ServerBackup findByArchivePath(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ServerBackup> criteria = cb.createQuery(ServerBackup.class);
        Root<ServerBackup> serverBackup = criteria.from(ServerBackup.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(serverBackup).where(cb.equal(serverBackup.get(ServerBackup_.name), email));
        criteria.select(serverBackup).where(cb.equal(serverBackup.get("archivePath"), email));
        return em.createQuery(criteria).getSingleResult();
    }
    
    public List<ServerBackup> findAllOrderedByCreationDate() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ServerBackup> criteria = cb.createQuery(ServerBackup.class);
        Root<ServerBackup> serverBackup = criteria.from(ServerBackup.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(serverBackup).orderBy(cb.asc(serverBackup.get(ServerBackup_.name)));
        criteria.select(serverBackup).orderBy(cb.asc(serverBackup.get("creationDate")));
        return em.createQuery(criteria).getResultList();
    }
}
