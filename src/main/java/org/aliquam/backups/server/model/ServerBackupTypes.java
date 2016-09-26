package org.aliquam.backups.server.model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ServerBackupTypes {
    
	public ServerBackupType[] getAvailableServerBackupTypes()
	{
		return ServerBackupType.values();
	}
}
