package org.aliquam.backups.server.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@ManagedBean
@XmlRootElement
public class WorldBackupRequest implements Serializable {

    @NotNull
    private String worldName = "UNSET";
    
    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }
}