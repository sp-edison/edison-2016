package kisti.edison.cloud.plugin.auth;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import javax.naming.directory.Attributes;
import javax.naming.directory.Attribute;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("LdapAdapter")
public class LdapAdapter {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private String ldapUri;
	private String ldapRootDN;
	private String ldapRootCN;
	private String ldapPassword;
	
	public LdapAdapter() {
	}

	public LdapAdapter(String ldapUri, String ldapRootDN, String ldapPassword) {
		this.ldapUri = ldapUri;
		this.ldapRootDN = ldapRootDN;
		this.ldapRootCN = "cn=Manager";
		this.ldapPassword = ldapPassword;
	}

	public LdapAdapter(String ldapUri, String ldapRootDN, String ldapRootCN, String ldapPassword) {
		this.ldapUri = ldapUri;
		this.ldapRootDN = ldapRootDN;
		this.ldapRootCN = ldapRootCN;
		this.ldapPassword = ldapPassword;
	}
	
	public String getLdapUri() {
		return ldapUri;
	}

	public void setLdapUri(String ldapUri) {
		this.ldapUri = ldapUri;
	}

	public String getLdapRootDN() {
		return ldapRootDN;
	}

	public void setLdapRootDN(String ldapRootDN) {
		this.ldapRootDN = ldapRootDN;
	}

	public String getLdapRootCN() {
		return ldapRootCN;
	}

	public void setLdapRootCN(String ldapRootCN) {
		this.ldapRootCN = ldapRootCN;
	}
	
	public String getLdapPassword() {
		return ldapPassword;
	}

	public void setLdapPassword(String ldapPassword) {
		this.ldapPassword = ldapPassword;
	}

	public void addUser(String userid, int uid, String gid, String password, String homeDir, String pubKey) {
		Hashtable<String, String> env = new Hashtable<String, String>();
		
		env.put( Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory" );
		env.put( Context.PROVIDER_URL, this.ldapUri );
		env.put( Context.SECURITY_PRINCIPAL, this.ldapRootCN +","+ this.ldapRootDN );
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
       	env.put( Context.SECURITY_CREDENTIALS, this.ldapPassword );
       	
//       	LOG.info("ldapUri:" + this.ldapUri);
//       	LOG.info("ldapRootDN:" + this.ldapRootDN);
       	
       	try{
       		DirContext ctx = new InitialDirContext(env);
       		Attributes attrs = new BasicAttributes(true);
       		
       		Attribute objclass = new BasicAttribute("objectclass");
       		objclass.add("top");
       		objclass.add("account");
       		objclass.add("posixAccount");
       		objclass.add("ldapPublicKey");
       		attrs.put(objclass);
       		
       		Attribute cname = new BasicAttribute("cn");
       		cname.add(userid);
       		attrs.put(cname);
       		
       		Attribute user_id = new BasicAttribute("uidNumber");
       		LOG.debug("LDAP CONFIG!!");
       		LOG.debug("UID:"+uid);
       		user_id.add(String.valueOf(uid));
       		attrs.put(user_id);
       		
       		Attribute group_id = new BasicAttribute("gidNumber");
       		LOG.debug("GID:"+gid);
       		group_id.add(gid);
       		attrs.put(group_id);
       		
       		Attribute homeDirectory = new BasicAttribute("homeDirectory");
       		LOG.debug("home:"+homeDir);
       		homeDirectory.add(homeDir);
       		attrs.put(homeDirectory);
       		
       		Attribute loginShell = new BasicAttribute("loginShell");
       		loginShell.add("/bin/bash");
       		attrs.put(loginShell);
       		
       		Attribute publicKey = new BasicAttribute("sshPublicKey");
//       		LOG.debug("key:" + pubKey);
       		publicKey.add(pubKey);
       		attrs.put(publicKey);
       		
       		
       		ctx.createSubcontext("uid="+userid +",ou=People,"+ getLdapRootDN(), attrs);
       	} catch(Exception e){
       		LOG.error(e);
       	}

	}
	public void delUser(String userid){
		Hashtable<String, String> env = new Hashtable<String, String>();
		
		env.put( Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory" );
		env.put( Context.PROVIDER_URL, this.ldapUri );
		env.put( Context.SECURITY_PRINCIPAL, this.ldapRootCN + "," + this.ldapRootDN );
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
       	env.put( Context.SECURITY_CREDENTIALS, this.ldapPassword );
       	
       	try{
       		DirContext ctx = new InitialDirContext(env);
       		
       		ctx.unbind("uid="+userid +",ou=People,"+ getLdapRootDN());
       	} catch(Exception e){
       		LOG.error(e);
       	}
	}
}
