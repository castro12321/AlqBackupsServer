package org.aliquam.backups.server.model;

public enum ServerBackupType {
	SERVER("Server"),
	WORLDS("Worlds"),
	SQL("Database"),
	WWW("Web"),
	OTHER("Other");
	
	private final String label;
	
	private ServerBackupType(final String label)
	{
		this.label = label;
	}
	
	public String getLabel()
	{
		return label;
	}
}
