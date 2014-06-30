package com.objectj.jsa.tool;

import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Binding;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class TestJNDI {
    public static void printJNDInames(Context ctx, String name) throws NamingException {
        //=-= //=-= //=-= System.out.println(" finding list of binding for name ---->" + name);
        NamingEnumeration namingenumeration = ctx.listBindings(name);
        while (namingenumeration.hasMore()) {
            Binding binding = (Binding)namingenumeration.next();
            //=-= //=-= //=-= System.out.println("found binding of name->object : " + binding.getName() + " -> " +binding.getObject());
            String newName = name.equals("") ? binding.getName() : name + "." + binding.getName();
            //=-= //=-= //=-= System.out.println(" Now let's try for " + newName);
            try{ printJNDInames(ctx, newName); }
            catch (NamingException e) {
                //=-= //=-= //=-= System.out.println("______________________________________________________");
            }
            
        }
    }
    
    public static void main(String[] args) {
        try {
            //I use this line to test weblogic
            Context ctx = null;
            Hashtable ht = new Hashtable();
            ht.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
            ht.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
            ht.put(Context.PROVIDER_URL, "localhost:8080");
            
            
            ctx = new InitialContext(ht);
            
            printJNDInames(ctx, "");
            
            //=-= //=-= //=-= System.out.println("done");
            // Use the context in your program
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


