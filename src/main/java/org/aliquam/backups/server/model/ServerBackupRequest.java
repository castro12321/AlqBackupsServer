package org.aliquam.backups.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity // TODO: @ManagedBean zamiast Entity? Nie potrzeba wtedy id
@XmlRootElement
public class ServerBackupRequest implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    private ServerBackupType type = ServerBackupType.OTHER;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServerBackupType getType() {
        return type;
    }

    public void setType(ServerBackupType type) {
        this.type = type;
    }
}