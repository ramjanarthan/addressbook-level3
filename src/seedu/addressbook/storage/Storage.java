package seedu.addressbook.storage;

import java.nio.file.Path;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile.StorageOperationException;

/**
 * Abstract class to facilitate DIP between 'Logic' and 'StorageFile'
 * 
 */

public abstract class Storage {
	
	public abstract boolean isValidPath(Path filePath);
	public abstract void save(AddressBook addressBook) throws StorageOperationException;
	public abstract AddressBook load() throws StorageOperationException; 
	public abstract String getPath();	

}
