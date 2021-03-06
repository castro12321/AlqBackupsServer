package org.aliquam.backups.server.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@ManagedBean
@XmlRootElement
public class ServerBackupRequest implements Serializable {

    @NotNull
    private ServerBackupType type = ServerBackupType.OTHER;
    
    public ServerBackupType getType() {
        return type;
    }

    public void setType(ServerBackupType type) {
        this.type = type;
    }
}