/** entityMaker.java
 *
 * Created on February 8, 2003, 11:34 PM
 */

package com.objectj.jsa.tool;

import java.io.File;
import org.apache.log4j.Logger;


/**
 *
 * @author Hossein Akhlaghpour
 */
public class Merger {

    protected static Logger log = Logger.getLogger(Merger.class.getName());

    public static void main(String[] args) throws Exception {
        if(args.length != 3) {
            log.error("\n"
            + " Wrong number of arguments: Aborting the operation ...\n"
            + " EntityBeanMaker Usage:\n"
            + "     merge inputFolder identifier outputFile"
            );
            return;
        }
        merge(args[0], args[1], args[2]);
        log.debug("done");
    }

    public static void merge(
    String topFolderName,
    String identifier,
    String destinationFileName
    ) throws Exception {

        File topFolder = new File(topFolderName);
        String[] files;
        if(!topFolder.exists() || !topFolder.isDirectory() || (files = topFolder.list()).length == 0) {
            log.warn(topFolder + " doesn't exist or is not a directory or is empty");
            return;
        }

        log.debug("Found " + files.length + " files");
        for(int index =0; index != files.length; index++) {
            File file = new File(topFolder, files[index]);
            log.debug("file " + file + " isDir " + file.isDirectory());
            if(file.isDirectory()) {
                log.debug("Checking folder " + files[index]);
                merge(file.toString(), identifier, destinationFileName);
            }
            else {
                int start, end;
                String fileName = file.toString();
                if( (start = fileName.lastIndexOf(identifier)) != -1 ) {
                    FileUtil.copyFile(fileName, destinationFileName, true);
                }
                else { // for now do nothing but lter you can copy that to jsp folder
                    log.debug(files[index] + " is not properties: ignoring it");
                }
            }
        }
    }
}
