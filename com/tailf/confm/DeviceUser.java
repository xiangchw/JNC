/*    -*- Java -*- 
 * 
 *  Copyright 2007 Tail-F Systems AB. All rights reserved. 
 *
 *  This software is the confidential and proprietary 
 *  information of Tail-F Systems AB.
 *
 *  $Id$
 *
 */
package com.tailf.confm;
import java.io.*;


/**
 * This class represents a user to be used 
 * with the {@link Device} class.
 * The idea being that we associate a local user name, with authentication
 * credentials at the managed device. Typically the element manager code
 * has a concept of users logged on to the element manager. These usere names
 * are typically not the same user names used at the managed devices. Thus
 * this class provides a mapping from local users to device users.
 * In the {@link Device} class we can install several users and then at 
 * connection time pick the DeviceUser associated to the user currently
 * logged in to the element manager. 
 *
 *
 */
public class DeviceUser implements Serializable {

    String localUser;
    String remoteUser;
    
    String password = null;
    File pemFile = null;
    char[] pemPrivateKey = null;
    String keyPassPhrase = null;


    /**
     * Constructor. Creates a user with a local name, remote user name, and
     * password.
     */
    public DeviceUser(String localUser, String remoteUser, String password) {
        this.localUser = localUser; this.remoteUser = remoteUser;
        this.password = password;
    }

    /**
     * Constructor. Creates a user with a local user name, remote user name.
     *
     */
    public DeviceUser(String localUser, String remoteUser,
                      File pemFile, String keyPassPhrase) {
        this.localUser = localUser; this.remoteUser = remoteUser;
        this.pemFile = pemFile;
        this.keyPassPhrase = keyPassPhrase;
    }

    /**
     *  Constructor. Creates a user with a local user name, remote user name.
     */
    public DeviceUser(String localUser, String remoteUser,
                      char[] pemPrivateKey, String keyPassPhrase) {
        this.localUser = localUser; this.remoteUser = remoteUser;
        this.pemPrivateKey = pemPrivateKey;
        this.keyPassPhrase = keyPassPhrase;
    }

    public String getLocalUser() { return localUser;}
    public String getRemoteuser() { return remoteUser; }
    public String getPassword() { return password;}
    public File   getPemFile() { return pemFile;}
    public char[] getPemPrivateKey() { return pemPrivateKey;}
    public String getKeyPassPhrase() { return keyPassPhrase;}

}

